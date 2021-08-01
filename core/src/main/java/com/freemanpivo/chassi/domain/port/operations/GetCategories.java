package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;

public interface GetCategories {

    List<Category> getCategories();

    Category getCategoryById(Long id);
}
