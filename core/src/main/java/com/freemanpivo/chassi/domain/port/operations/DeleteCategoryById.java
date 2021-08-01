package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Category;

public interface DeleteCategoryById {

    public Boolean removeCategoryInDatabase(Category category);
}
