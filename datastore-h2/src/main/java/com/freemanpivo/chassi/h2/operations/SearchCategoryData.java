package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SearchCategories;
import com.freemanpivo.chassi.h2.mapper.CategoryEntityMapper;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchCategoryData implements SearchCategories {

    private final CategoryEntityRepository repository;
    private final CategoryEntityMapper mapper;

    @Override
    public List<Category> getAllCategories() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Long id) {
        final var category = repository.findById(id);
        if(category.isPresent())
            return mapper.toModel(category.get());

        throw new BusinessException(ErrorMessageEnum.E011.getCode(), ErrorMessageEnum.E011.getMessage());
    }
}
