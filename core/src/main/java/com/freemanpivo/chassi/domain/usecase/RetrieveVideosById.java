package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosByIdCommand;
import com.freemanpivo.chassi.domain.port.operations.GetVideosById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveVideosById implements GetVideosByIdCommand {

    private final GetVideosById getVideosById;


    @Override
    public Video findVideosById(Long id) {
        final var videos = getVideosById.getById(id);
        if(videos == null) {
           throw new BusinessException(ErrorMessageEnum.E007.getCode(), ErrorMessageEnum.E007.getMessage());
        }
        return videos;
    }
}
