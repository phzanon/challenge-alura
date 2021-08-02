package com.freemanpivo.chassi.web.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosByIdCommand;
import com.freemanpivo.chassi.domain.port.command.GetVideosByTitleCommand;
import com.freemanpivo.chassi.domain.port.command.GetVideosCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoGetController {

    private final GetVideosCommand command;
    private final GetVideosByIdCommand getVideosByIdCommand;
    private final GetVideosByTitleCommand getVideosByTitleCommand;

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAll() {
        return ResponseEntity.ok(command.findVideos());
    }

    @GetMapping
    public ResponseEntity<Video> getById(@RequestParam("id") String id) {
        return ResponseEntity.ok(getVideosByIdCommand.findVideosById(Long.parseLong(id)));
    }
    
    @GetMapping("/search")
    public ResponseEntity<Video> getByTitle(@RequestParam("titulo") String title) {
		return ResponseEntity.ok(getVideosByTitleCommand.findVideosByTitle(title));
    }
}
