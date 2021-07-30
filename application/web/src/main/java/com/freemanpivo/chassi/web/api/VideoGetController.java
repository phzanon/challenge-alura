package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosCommand;
import com.freemanpivo.chassi.web.dto.response.ResponseGetAll;
import com.freemanpivo.chassi.web.dto.response.ResponseGetDto;
import com.freemanpivo.chassi.web.mappers.VideoGetDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoGetController {

    private final GetVideosCommand command;
    private final VideoGetDtoMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAll() {
        return ResponseEntity.ok(command.findVideos());
    }

    @GetMapping("/byCategoria")
    public ResponseEntity<ResponseGetAll> getVideos() {
        final var videos = command.findVideos();
        return ResponseEntity.ok(new ResponseGetAll(videos
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList())));
    }
}
