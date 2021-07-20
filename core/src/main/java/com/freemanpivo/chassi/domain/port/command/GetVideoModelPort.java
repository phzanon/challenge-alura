package com.freemanpivo.chassi.domain.port.command;

import com.freemanpivo.chassi.domain.model.Video;

public interface GetVideoModelPort {
	Video save(String id, String titulo, String descricao, String url);

	<VideoDto> VideoDto findAll();
}
