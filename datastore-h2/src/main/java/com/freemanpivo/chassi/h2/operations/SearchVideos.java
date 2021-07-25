package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.GetVideos;
import com.freemanpivo.chassi.domain.port.command.GetVideosPort;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchVideos implements GetVideos {
    private final VideoEntityRepository repository;
    private final VideoEntityMapper mapper;

    @Override
    public List<Video> getAll() {
        final var videoEntities = repository.findAll();
        if(!videoEntities.isEmpty()) {
            return videoEntities
                    .stream()
                    .map(mapper::toModel)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}
