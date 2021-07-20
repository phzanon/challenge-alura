package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.GetVideosById;
import com.freemanpivo.chassi.domain.port.command.GetVideosByIdPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveVideosById implements GetVideosByIdPort {

    private final GetVideosById getVideosById;


    @Override
    public Video findVideosById(String id) {
        final var videos = getVideosById.getById(id);
        if(videos == null) {
           throw new RuntimeException("Empty videos List");
        }
        return videos;
    }
}
