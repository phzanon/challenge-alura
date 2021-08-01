package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.operations.DeleteCategoryById;
import com.freemanpivo.chassi.h2.mapper.CategoryEntityMapper;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryInDatabase implements DeleteCategoryById {

    private final CategoryEntityRepository repository;
    private final CategoryEntityMapper mapper;


    @Override
    public Boolean removeCategoryInDatabase(Category category) {
        repository.delete(mapper.toEntity(category));
        return true;
    }
}
