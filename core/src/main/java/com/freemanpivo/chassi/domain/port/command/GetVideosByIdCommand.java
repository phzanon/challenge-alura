package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Video;

public interface GetVideosByIdCommand {

	Video findVideosById(Long id);
} 
