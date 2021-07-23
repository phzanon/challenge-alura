package com.freemanpivo.chassi.domain.exception;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {

    E000("000", "Campos Video Inválidos"),
    E001("001", "Campos do vídeo devem ser preenchidos!"),
    E002("002","Campo Id não foi preenchido!"),
    E003("003", "Campo Descrição não foi preenchido!"),
    E004("004","Campo Título não foi preenchido!"),
    E005("005","Campo Url não foi preenchido!"),
    E006("006","Id não encontrado!"),
    ;

    private final String code;
    private final String message;

    ErrorMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
