package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;

public interface SearchCategories {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
