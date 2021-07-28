package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.web.dto.response.ResponseGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VideoGetDtoMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ResponseGetDto toDto(Video video);

}
