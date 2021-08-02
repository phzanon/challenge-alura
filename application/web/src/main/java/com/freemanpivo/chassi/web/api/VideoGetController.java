package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.GetVideosByIdCommand;
import com.freemanpivo.chassi.domain.port.command.GetVideosCommand;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.util.IdValidator;
import com.freemanpivo.chassi.web.dto.response.ResponseGetAll;
import com.freemanpivo.chassi.web.mappers.VideoGetDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoGetController {

    private final GetVideosCommand command;
    private final GetVideosByIdCommand getVideosByIdCommand;

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAll() {
        return ResponseEntity.ok(command.findVideos());
    }

    @GetMapping
    public ResponseEntity<Video> getById(@RequestParam("id") String id) {
        return ResponseEntity.ok(getVideosByIdCommand.findVideosById(Long.parseLong(id)));
    }
}
