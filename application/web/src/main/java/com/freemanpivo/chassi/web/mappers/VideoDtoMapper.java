package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.web.dto.VideoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoDtoMapper {
    Video toModel(VideoDto videoDto);

    VideoDto toDto(Video video);
}
