package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.web.dto.response.ResponseSaveVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseSaveVideoDtoMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ResponseSaveVideo toDto(Video video);
}
