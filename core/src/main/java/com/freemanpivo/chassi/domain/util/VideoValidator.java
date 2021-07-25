package com.freemanpivo.chassi.domain.util;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorField;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoValidator {

    public static void validate(Video video) {
        if(video == null)
            throw new BusinessException(ErrorMessageEnum.E001.getCode(),
                    ErrorMessageEnum.E001.getMessage());
        validarCampos(video);
    }

    public static void validarCampos(Video video) {

        List<ErrorField> errors = new ArrayList<>();

//        if(video.getId() == null || video.getId().equals(""))
//            errors.add(new ErrorField(ErrorMessageEnum.E002.getCode(),
//                    ErrorMessageEnum.E002.getMessage(), ""));
        if(video.getDescricao() == null || video.getDescricao().equals(""))
            errors.add(new ErrorField(ErrorMessageEnum.E003.getCode(),
                    ErrorMessageEnum.E003.getMessage(), ""));
        if(video.getTitulo() == null || video.getTitulo().equals(""))
            errors.add(new ErrorField(ErrorMessageEnum.E004.getCode(),
                    ErrorMessageEnum.E004.getMessage(), ""));
        if(video.getUrl() == null || video.getUrl().equals(""))
            errors.add(new ErrorField(ErrorMessageEnum.E005.getCode(),
                    ErrorMessageEnum.E005.getMessage(), ""));

        if(!errors.isEmpty()) {
            throw new BusinessException(ErrorMessageEnum.E000.getCode(), ErrorMessageEnum.E000.getMessage(), errors);
        }
    }
}
