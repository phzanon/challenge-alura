package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.web.dto.CategoryPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryPostDtoMapper {
	Category toModel(CategoryPostDto categoryPostDto);
}
