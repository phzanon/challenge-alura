package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SaveVideoCommand;
import com.freemanpivo.chassi.domain.port.operations.SaveVideoModelPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveVideoInfo implements SaveVideoCommand {

	private final SaveVideoModelPort port;

	@Override
	public Video save(Video video) {
		video = port.save(video);
		if (video == null) {
			throw new BusinessException(ErrorMessageEnum.E000.getCode(), ErrorMessageEnum.E000.getMessage());
		}
		return video;
	}

}
