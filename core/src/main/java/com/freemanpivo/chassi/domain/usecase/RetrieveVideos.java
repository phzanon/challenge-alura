package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosCommand;
import com.freemanpivo.chassi.domain.port.operations.GetVideos;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RetrieveVideos implements GetVideosCommand {

    private final GetVideos getVideos;

    @Override
    public List<Video> findVideos() {
        final var videos = getVideos.getAll();
        if(videos.isEmpty()) {
           throw new RuntimeException("Empty videos List");
        }
        return videos;
    }
}
