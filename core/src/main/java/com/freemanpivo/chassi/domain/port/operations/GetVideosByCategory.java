package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Video;

import java.util.List;

public interface GetVideosByCategory {

    List<Video> getAllVideosByCategory(Long id);
}
