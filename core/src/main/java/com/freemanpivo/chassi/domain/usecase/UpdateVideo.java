package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.UpdateVideoCommand;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideosById;
import com.freemanpivo.chassi.domain.usecase.SaveVideoInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateVideo implements UpdateVideoCommand {

    private final RetrieveVideosById retrieveVideos;
    private final SaveVideoInfo saveVideoInfo;

    @Override
    public Video update(Video video) {
        final var exists = retrieveVideos.findVideosById(video.getId());
        if(video != null) {
            return saveVideoInfo.save(video);
        }
        throw new BusinessException(ErrorMessageEnum.E007.getCode(), ErrorMessageEnum.E007.getMessage());
    }
}
