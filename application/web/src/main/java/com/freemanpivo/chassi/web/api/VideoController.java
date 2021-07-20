package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.port.command.GetVideoModelPort;
import com.freemanpivo.chassi.web.dto.VideoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

    final GetVideoModelPort command;

    @PostMapping(name = "/")
    public ResponseEntity<VideoDto> save(@RequestBody VideoDto video) {
        log.info("Request Video: {}", video);
        command.save(video.getId(),
                    video.getTitulo(),
                    video.getDescricao(),
                    video.getUrl());
        return ResponseEntity.ok(video);
    }
    
    
    @GetMapping(name = "/")
    public ResponseEntity<VideoDto> findAll() {
        log.info("Request todos os Videos");
        VideoDto videoDto = command.findAll();
        return ResponseEntity.ok(videoDto);
    }
}
