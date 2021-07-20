package com.freemanpivo.chassi.domain.port;

import com.freemanpivo.chassi.domain.model.Video;

import java.util.List;

public interface GetVideosById {

   Video getById(String id);
}
