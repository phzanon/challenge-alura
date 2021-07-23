package com.freemanpivo.chassi.domain.port;

import com.freemanpivo.chassi.domain.model.Video;

public interface UpdateVideoModelPort {

    Video update(String id, Video video);

}
