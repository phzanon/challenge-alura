package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Video;

public interface UpdateVideoCommand {
    Video update(Video video);
}
