package com.freemanpivo.chassi.h2.mapper;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.h2.entity.VideoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoDtoEntityMapper {
	VideoEntity toEntity(Video video);

	Video toModel(VideoEntity videoEntity);
}
