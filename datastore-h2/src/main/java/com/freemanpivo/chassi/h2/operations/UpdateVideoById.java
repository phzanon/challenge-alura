package com.freemanpivo.chassi.h2.operations;

import org.springframework.stereotype.Component;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.operations.UpdateVideoModelPort;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateVideoById implements UpdateVideoModelPort {

	private final VideoEntityRepository repository;
	private final VideoEntityMapper mapper;

	@Override
	public Video update(Video video) {

		final var videoEntitie = repository.findById(video.getId());

		if (videoEntitie.isPresent()) {

			repository.save(mapper.toEntity(video));

			return video;
		}
		throw new BusinessException(ErrorMessageEnum.E007.getCode(), ErrorMessageEnum.E007.getMessage());
	}
}
