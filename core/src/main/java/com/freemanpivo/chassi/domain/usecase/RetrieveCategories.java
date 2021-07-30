package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SearchAllCategories;
import com.freemanpivo.chassi.domain.port.operations.RetrieveAllCategories;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RetrieveCategories implements SearchAllCategories {

    private final RetrieveAllCategories port;


    @Override
    public List<Category> getAllCategories() {
        final var categories = port.getCategories();
        if(!categories.isEmpty())
            return categories;
        return List.of();
    }
}
