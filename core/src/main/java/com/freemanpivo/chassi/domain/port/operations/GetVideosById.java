package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Video;

public interface GetVideosById {

   Video getById(Long id);
}
