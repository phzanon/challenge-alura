package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SearchAllCategories;
import com.freemanpivo.chassi.h2.mapper.CategoryEntityMapper;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchCategories implements SearchAllCategories {

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
}
