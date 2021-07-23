package com.freemanpivo.chassi.h2;

import org.springframework.stereotype.Component;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.UpdateVideoModelPort;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateVideo implements UpdateVideoModelPort {

	private final VideoEntityRepository repository;
	private final VideoEntityMapper mapper;

	@Override
	public Video update(String id, Video video) {

		final var videoEntitie = repository.findById(id);

		if (videoEntitie.isPresent()) {

			repository.save(mapper.toEntity(video));

			return video;
		}
		throw new BusinessException(ErrorMessageEnum.E006.getCode(), ErrorMessageEnum.E006.getMessage());
	}
}
