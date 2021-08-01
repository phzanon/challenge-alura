package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.port.command.SaveVideoCommand;
import com.freemanpivo.chassi.domain.port.command.UpdateVideoCommand;
import com.freemanpivo.chassi.domain.util.VideoValidator;
import com.freemanpivo.chassi.web.dto.VideoDto;
import com.freemanpivo.chassi.web.dto.VideoPostDto;
import com.freemanpivo.chassi.web.mappers.VideoDtoMapper;
import com.freemanpivo.chassi.web.mappers.VideoPostDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoPostController {

    private final SaveVideoCommand command;
    private final VideoDtoMapper mapper;
    private final VideoPostDtoMapper videoPostDtoMapper;
    private final UpdateVideoCommand updateVideoCommand;

    @PostMapping
    public ResponseEntity<VideoDto> save(@RequestBody VideoPostDto videoDto) {
        log.info("Request Video: {}", videoDto);
        final var video = videoPostDtoMapper.toModel(videoDto);
        VideoValidator.validate(video);
        return ResponseEntity.ok(mapper.toDto(command.save(video)));
    }

    @PutMapping
    public ResponseEntity<VideoDto> update(@RequestBody VideoDto videoDto) {
        log.info("Request Video: {}", videoDto);
        final var video = mapper.toModel(videoDto);
        VideoValidator.validate(video);
        return ResponseEntity.ok(mapper.toDto(updateVideoCommand.update(video)));
    }
}
