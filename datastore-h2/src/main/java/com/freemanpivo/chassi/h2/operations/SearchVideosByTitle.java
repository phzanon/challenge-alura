package com.freemanpivo.chassi.h2.operations;

import org.springframework.stereotype.Component;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByTitle;
import com.freemanpivo.chassi.h2.entity.VideoEntity;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchVideosByTitle implements GetVideosByTitle {
	private final VideoEntityRepository repository;
	private final VideoEntityMapper mapper;

	@Override
	public Video getByTitle(String title) {
		final var videoEntitie = repository.findVideoEntityByTitulo(title);
		if (!videoEntitie.isEmpty()) {
			return mapper.toModel((VideoEntity) videoEntitie.get());

		}
		return null;
	}

}
