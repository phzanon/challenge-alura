package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.User;
import com.freemanpivo.chassi.domain.port.GetModelPort;
import com.freemanpivo.chassi.web.dto.UserDto;
import com.freemanpivo.chassi.web.mappers.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserGetController {

    private final GetModelPort<User> retrieveUsers;
    private final UserDtoMapper mapper;

    @GetMapping(value = "/{id}")
    private ResponseEntity<UserDto> getUserDetais(@PathVariable("id") final Long id) {
        final var user = retrieveUsers.getDetails(id);

        return ResponseEntity.ok(mapper.toDto(user));
    }

    @GetMapping(value = "/")
    private ResponseEntity<List<UserDto>> getAllUsers() {
        final var users = retrieveUsers.getAll();
        final var usersDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());

        return ResponseEntity.ok(usersDtos);
    }
}
