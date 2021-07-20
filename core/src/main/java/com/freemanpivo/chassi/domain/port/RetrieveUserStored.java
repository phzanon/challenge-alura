package com.freemanpivo.chassi.domain.port;

import com.freemanpivo.chassi.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserStored {
    Optional<User> getById(Long id);
    List<User> getAll();
}
