package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.port.command.GetVideosByIdCommand;
import com.freemanpivo.chassi.domain.port.command.GetVideosCommand;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.util.IdValidator;
import com.freemanpivo.chassi.web.dto.response.ResponseGetAll;
import com.freemanpivo.chassi.web.mappers.VideoGetDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@Slf4j
public class VideoByCategoryController {

    private final VideoGetDtoMapper mapper;
    private final SearchVideoByCategory searchVideoByCategory;

    @GetMapping("/{id}/videos")
    public ResponseEntity<ResponseGetAll> getAllVideosByCategory(@PathVariable("id") String id) {
        IdValidator.validate(id);
        final var videos = searchVideoByCategory.getVideos(Long.parseLong(id));
        return ResponseEntity.ok(new ResponseGetAll(videos
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList())));
    }
}
