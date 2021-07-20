package com.freemanpivo.chassi.h2.mapper;

import com.freemanpivo.chassi.domain.model.User;
import com.freemanpivo.chassi.h2.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toModel(UserEntity entity);
}
