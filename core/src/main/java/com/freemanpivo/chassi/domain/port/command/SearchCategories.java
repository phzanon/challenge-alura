package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;

public interface SearchAllCategories {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
