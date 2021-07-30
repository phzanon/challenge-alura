package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Category;

import java.util.List;

public interface RetrieveAllCategories {

    List<Category> getCategories();
}
