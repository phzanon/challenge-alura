package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosByTitleCommand;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByTitle;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveVideosByTitle implements GetVideosByTitleCommand {

	private final GetVideosByTitle getVideosByTitle;

	@Override
	public Video findVideosByTitle(String title) {
		final var videos = getVideosByTitle.getByTitle(title);
		if (videos == null) {
			throw new BusinessException(ErrorMessageEnum.E007.getCode(), ErrorMessageEnum.E007.getMessage());
		}
		return videos;
	}
}
