package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Video;

public interface GetVideosByIdPort {

	Video findVideosById(String id);
} 
