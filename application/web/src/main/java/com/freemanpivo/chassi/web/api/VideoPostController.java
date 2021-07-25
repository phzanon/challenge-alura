package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.port.command.SaveVideoCommand;
import com.freemanpivo.chassi.domain.util.VideoValidator;
import com.freemanpivo.chassi.web.dto.VideoDto;
import com.freemanpivo.chassi.web.mappers.VideoDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoPostController {

    private final SaveVideoCommand command;
    private final VideoDtoMapper mapper;

    @PostMapping(name = "/")
    public ResponseEntity<VideoDto> save(@RequestBody VideoDto videoDto) {
        log.info("Request Video: {}", videoDto);
        final var video = mapper.toModel(videoDto);
        VideoValidator.validate(video);
        return ResponseEntity.ok(mapper.toDto(command.save(video)));
    }
}
