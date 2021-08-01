package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaDtoMapper {
    Category toModel(CategoryD )
}
