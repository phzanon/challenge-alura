package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.DeleteCategoryCommand;
import com.freemanpivo.chassi.domain.port.operations.DeleteCategoryById;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DeleteCategory implements DeleteCategoryCommand {

    private final DeleteCategoryById port;
    private final RetrieveCategories retrieveCategories;

    @Override
    public Boolean deleteCategory(Long id) {
        Optional<Category> category = retrieveCategories.getCategoryById(id);
        if(category.isPresent())
            return port.removeCategoryInDatabase(category.get());
        throw new BusinessException(ErrorMessageEnum.E011.getCode(), ErrorMessageEnum.E011.getMessage());
    }
}
