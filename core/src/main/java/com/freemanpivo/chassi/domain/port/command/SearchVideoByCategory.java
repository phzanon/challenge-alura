package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Video;

import java.util.List;

public interface SearchVideoByCategory {

    List<Video> getVideos(Long id);
}
