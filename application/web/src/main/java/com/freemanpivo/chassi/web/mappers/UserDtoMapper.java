package com.freemanpivo.chassi.web.mappers;

import org.mapstruct.Mapper;

import com.freemanpivo.chassi.domain.model.User;
import com.freemanpivo.chassi.web.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserDto toDto(User model);
    
    User toModel(UserDto userDTO);
}
