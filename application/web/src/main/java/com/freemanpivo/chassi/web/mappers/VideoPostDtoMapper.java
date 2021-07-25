package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.web.dto.VideoPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoPostDtoMapper {
    Video toModel(VideoPostDto videoPostDto);
}
