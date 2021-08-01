package com.freemanpivo.chassi.domain.usecase;

import java.util.List;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByCategory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveVideoByCategory implements SearchVideoByCategory {

    private final GetVideosByCategory getVideosByCategory;

    @Override
    public List<Video> getVideos(Long id) {
        final var videos = getVideosByCategory.getAllVideosByCategory(id);

        if(!videos.isEmpty())
            return videos;
        return List.of();
    }
}
