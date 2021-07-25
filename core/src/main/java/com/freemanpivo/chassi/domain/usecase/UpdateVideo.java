package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SaveVideoCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateVideo implements SaveVideoCommand {

	private final SaveVideoCommand port;

	@Override
	public Video save(Video video) {
		Video video1 = port.save(video);
		if (video1 == null) {
			throw new BusinessException(ErrorMessageEnum.E008.getCode(), ErrorMessageEnum.E008.getMessage());
		}
		return video1;
	}

}
