package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SaveCategoryCommand;
import com.freemanpivo.chassi.domain.port.operations.SaveCategoryModelPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveCategoryInfo implements SaveCategoryCommand {

	private final SaveCategoryModelPort port;

	@Override
	public Category save(Category category) {
		category = port.save(category);
		if (category == null) {
			throw new BusinessException(ErrorMessageEnum.E000.getCode(), ErrorMessageEnum.E000.getMessage());
		}
		return category;
	}

}
