package com.freemanpivo.chassi.h2;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.SaveVideoModelPort;
import com.freemanpivo.chassi.h2.entity.VideoEntity;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveVideo implements SaveVideoModelPort {

	private final VideoEntityRepository repository;
	private final VideoEntityMapper mapper;

	@Override
	public Video save(Video video) {
		VideoEntity videoEntity = repository.save(mapper.toEntity(video));
		return mapper.toModel(videoEntity);
	}
}
