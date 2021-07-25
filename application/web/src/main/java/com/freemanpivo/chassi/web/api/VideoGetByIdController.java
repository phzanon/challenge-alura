package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosByIdCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoGetByIdController {

    private final GetVideosByIdCommand command;

    @GetMapping
    public ResponseEntity<Video> getById(@RequestParam("id") String id) {
        return ResponseEntity.ok(command.findVideosById(Long.parseLong(id)));
    }
}
