package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.GetVideos;
import com.freemanpivo.chassi.domain.port.command.GetVideosPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RetrieveVideos implements GetVideosPort {

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
