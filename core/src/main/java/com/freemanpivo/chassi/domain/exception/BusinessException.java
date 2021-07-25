package com.freemanpivo.chassi.domain.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException{
    private final ErrorMessage errorMessage;

    public BusinessException(String code, String message, List<ErrorField> fields) {
        super();
        errorMessage = new ErrorMessage(code, message, fields);
    }

    public BusinessException(String code, String message) {
        super();
        errorMessage = new ErrorMessage(code, message, List.of());
    }

    public BusinessException(String code, String message, ErrorField uniqueField) {
        super();
        List<ErrorField> uniqueFieldList = new ArrayList<>();
        uniqueFieldList.add(uniqueField);
        errorMessage = new ErrorMessage(code, message, uniqueFieldList);
    }

    public ErrorMessage getError() { return errorMessage; }
}
