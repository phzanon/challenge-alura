package com.freemanpivo.chassi.h2.operations;

import org.springframework.stereotype.Component;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.operations.SaveCategoryModelPort;
import com.freemanpivo.chassi.h2.mapper.CategoryEntityMapper;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SaveCategory implements SaveCategoryModelPort {

	private final CategoryEntityRepository repository;
	private final CategoryEntityMapper mapper;

	@Override
	public Category save(Category category) {
		var categoryEntity = repository.save(mapper.toEntity(category));
		return mapper.toModel(categoryEntity);
	}
}
