package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SearchCategoriesCommand;
import com.freemanpivo.chassi.domain.port.operations.GetCategories;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RetrieveCategories implements SearchCategoriesCommand {

    private final GetCategories port;


    @Override
    public List<Category> getAllCategories() {
        final var categories = port.getCategories();
        if(!categories.isEmpty())
            return categories;
        return List.of();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        final var category = port.getCategoryById(id);

        if(category == null) {
            throw new BusinessException(ErrorMessageEnum.E011.getCode(), ErrorMessageEnum.E011.getMessage());
        }

        return category;
    }
}
