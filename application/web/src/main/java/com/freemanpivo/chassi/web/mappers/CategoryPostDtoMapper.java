package com.freemanpivo.chassi.web.mappers;

import org.mapstruct.Mapper;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.web.dto.CategoryPostDto;

@Mapper(componentModel = "spring")
public interface CategoryPostDtoMapper {
	Category toModel(CategoryPostDto categoryPostDto);
}
