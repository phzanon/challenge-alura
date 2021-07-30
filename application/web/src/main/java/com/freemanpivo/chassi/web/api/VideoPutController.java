package com.freemanpivo.chassi.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freemanpivo.chassi.domain.port.operations.UpdateVideoModelPort;
import com.freemanpivo.chassi.domain.util.VideoValidator;
import com.freemanpivo.chassi.web.dto.VideoDto;
import com.freemanpivo.chassi.web.mappers.VideoDtoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoPutController {

    private final UpdateVideoModelPort command;
    private final VideoDtoMapper mapper;

    @PutMapping
    public ResponseEntity<VideoDto> update(@RequestBody VideoDto videoDto) {
        log.info("Request Video: {}", videoDto);
        final var video = mapper.toModel(videoDto);
        VideoValidator.validate(video);
        return ResponseEntity.ok(mapper.toDto(command.update(video)));
    }
}
