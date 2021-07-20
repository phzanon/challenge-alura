package com.freemanpivo.chassi.web.api;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freemanpivo.chassi.domain.port.command.GetVideosByIdPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoGetByIdController {

    private final GetVideosByIdPort command;

    @GetMapping("/")
    public ResponseEntity getById(@PathParam("id") String id) {
        return ResponseEntity.ok(command.findVideosById(id));
    }
}
