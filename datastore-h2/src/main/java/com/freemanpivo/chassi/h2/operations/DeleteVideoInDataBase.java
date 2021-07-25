package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.port.operations.DeleteVideoPort;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteVideoInDataBase implements DeleteVideoPort {

    private final VideoEntityRepository repository;

    @Override
    public Boolean delete(Long id) {
        final var video = repository.findById(id);

        if(video.isPresent()) {
            repository.delete(video.get());
            return true;
        }
        throw new BusinessException(ErrorMessageEnum.E010.getCode(), ErrorMessageEnum.E010.getMessage());
    }
}
