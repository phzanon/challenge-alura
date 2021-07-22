package com.freemanpivo.chassi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String code;
    private String message;
    private List<ErrorField> fields;
}
