package com.freemanpivo.chassi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorField {

    private String name;
    private String message;
    private String value;
}
