package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface GetCategories {

    List<Category> getCategories();

    Optional<Category> getCategoryById(Long id);
}
