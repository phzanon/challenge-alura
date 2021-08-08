package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface SearchCategoriesCommand {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);
}
