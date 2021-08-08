package com.freemanpivo.chassi.domain.port.operations;

import com.freemanpivo.chassi.domain.model.Video;

public interface GetVideosByTitle {

	Video getByTitle(String title);

}
