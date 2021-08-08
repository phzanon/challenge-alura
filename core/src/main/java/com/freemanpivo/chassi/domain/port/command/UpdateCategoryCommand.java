package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Category;

public interface UpdateCategoryCommand {

    Category updateCategory(Category category);
}
