package com.freemanpivo.chassi.web.mappers;

import org.mapstruct.Mapper;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.web.dto.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {
	Category toModel(CategoryDto categoryDto);

	CategoryDto toDto(Category category);

	default String fromModel(Long id) {
		return id == null ? null : id.toString();
	}

	default Long fromDto(String id) {
		return id == null ? null : Long.parseLong(id);
	}
}
