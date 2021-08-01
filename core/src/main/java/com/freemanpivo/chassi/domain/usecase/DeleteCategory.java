package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.DeleteCategoryCommand;
import com.freemanpivo.chassi.domain.port.command.SearchCategories;
import com.freemanpivo.chassi.domain.port.operations.DeleteCategoryById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCategory implements DeleteCategoryCommand {

    private final DeleteCategoryById port;
    private final SearchCategories searchCategories;

    @Override
    public Boolean deleteCategory(Long id) {
        Category category = searchCategories.getCategoryById(id);
        if(category != null)
            return port.removeCategoryInDatabase(category);
        throw new BusinessException(ErrorMessageEnum.E011.getCode(), ErrorMessageEnum.E011.getMessage());
    }
}
