package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.port.command.DeleteVideoCommand;
import com.freemanpivo.chassi.domain.port.operations.DeleteVideoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteVideo implements DeleteVideoCommand {

    private final DeleteVideoPort port;

    @Override
    public Boolean deleteVideoById(Long id) {
        return port.delete(id);
    }
}
