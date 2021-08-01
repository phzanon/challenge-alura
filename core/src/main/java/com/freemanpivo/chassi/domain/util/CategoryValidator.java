package com.freemanpivo.chassi.domain.util;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorField;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static void validate(Category category) {
        if(category == null) {
            throw new BusinessException(ErrorMessageEnum.E004.getCode(), ErrorMessageEnum.E004.getMessage());
        }
        List<ErrorField> errors = new ArrayList<>();
        validateCategoryFields(category, errors);

        if(!errors.isEmpty()) {
            throw new BusinessException(ErrorMessageEnum.E013.getCode(), ErrorMessageEnum.E013.getMessage(), errors);
        }
    }

    public static void validateCategoryFields(Category category, List<ErrorField> errors) {

        if(category.getTitulo().isEmpty()) {
            errors.add(new ErrorField(ErrorMessageEnum.E004.getCode(), ErrorMessageEnum.E004.getMessage(), null));
        }

        if(category.getCor().isEmpty()) {
            errors.add(new ErrorField(ErrorMessageEnum.E014.getCode(), ErrorMessageEnum.E014.getMessage(), null));
        }
    }
}
