package com.freemanpivo.chassi.h2;

import org.springframework.stereotype.Component;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.GetVideosById;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchVideosById implements GetVideosById {
	private final VideoEntityRepository repository;
	private final VideoEntityMapper mapper;

	@Override
	public Video getById(String id) {
		final var videoEntitie = repository.findById(id);
		if (!videoEntitie.isEmpty()) {
			return mapper.toModel(videoEntitie.get());

		}
		return null;
	}

}