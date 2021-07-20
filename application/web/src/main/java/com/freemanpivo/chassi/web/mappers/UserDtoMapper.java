package com.freemanpivo.chassi.web.mappers;

import com.freemanpivo.chassi.domain.model.User;
import com.freemanpivo.chassi.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserDto toDto(User model);
}
