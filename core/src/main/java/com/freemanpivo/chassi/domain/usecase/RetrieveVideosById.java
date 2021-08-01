package com.freemanpivo.chassi.domain.usecase;

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
           throw new RuntimeException("Empty videos List");
        }
        return videos;
    }
}
