package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SaveVideoCommand;
import com.freemanpivo.chassi.domain.port.command.SearchCategoriesCommand;
import com.freemanpivo.chassi.domain.port.operations.SaveVideoModelPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveVideoInfo implements SaveVideoCommand {

	private final SaveVideoModelPort port;
	private final RetrieveCategories retrieveCategories;
	private static final Long FREE_CATEGORY = 1L;

	@Override
	public Video save(Video video) {

		if(video.getCategory() == null) {
			video.setCategory(retrieveCategories.getCategoryById(FREE_CATEGORY).get());
		} else {
			final var category = retrieveCategories.getCategoryById(video.getCategory().getId());

			if(category.isEmpty()) {
				video.setCategory(retrieveCategories.getCategoryById(FREE_CATEGORY).get());
			}
		}

		video = port.save(video);
		if (video == null) {
			throw new BusinessException(ErrorMessageEnum.E000.getCode(), ErrorMessageEnum.E000.getMessage());
		}
		return video;
	}

}
