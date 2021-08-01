package com.freemanpivo.chassi.domain.util;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;

public class IdValidator {

    public static void validate(String id) {
        if(id == null)
            throw new BusinessException(ErrorMessageEnum.E012.getCode(), ErrorMessageEnum.E012.getMessage());

        validarIdRecebido(id);
    }

    public static void validarIdRecebido(String id) {
        try {
            final var receivedId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorMessageEnum.E012.getCode(), ErrorMessageEnum.E012.getMessage());
        }
    }
}
