package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Category;

public interface SaveCategoryCommand {
	Category save(Category category);
}
