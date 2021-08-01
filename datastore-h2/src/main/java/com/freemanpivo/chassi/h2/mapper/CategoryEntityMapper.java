package com.freemanpivo.chassi.h2.mapper;

import org.mapstruct.Mapper;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.h2.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

	Category toModel(CategoryEntity categoryEntity);

	CategoryEntity toEntity(Category category);
}
