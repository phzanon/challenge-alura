package com.freemanpivo.chassi.domain.usecase;

import java.util.List;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SaveVideoModelPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveVideoInfo implements SaveVideoModelPort {

	private final com.freemanpivo.chassi.domain.port.SaveVideoModelPort port;

	@Override
	public Video save(String id, String titulo, String descricao, String url) {
		Video video = new Video(id, titulo, descricao, url);
		Video video1 = port.save(video);
		if (video1 == null) {
			throw new RuntimeException("Erro ao salvar", null);
		}
		return video1;
	}

}
