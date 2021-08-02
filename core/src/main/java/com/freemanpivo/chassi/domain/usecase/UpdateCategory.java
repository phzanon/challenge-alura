package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.UpdateCategoryCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCategory implements UpdateCategoryCommand {

    private final RetrieveCategories retrieveCategories;
    private final SaveCategoryInfo saveCategoryInfo;

    @Override
    public Category updateCategory(Category category) {
        final var existsCategory = retrieveCategories.getCategoryById(category.getId());

        if(existsCategory != null) {
            return saveCategoryInfo.save(category);
        }

        throw new BusinessException(ErrorMessageEnum.E011.getCode(), ErrorMessageEnum.E011.getMessage());
    }
}
