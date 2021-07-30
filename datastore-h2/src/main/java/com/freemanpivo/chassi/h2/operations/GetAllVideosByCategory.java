package com.freemanpivo.chassi.h2.operations;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByCategory;
import com.freemanpivo.chassi.h2.mapper.VideoEntityMapper;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllVideosByCategory implements GetVideosByCategory {

    private final VideoEntityRepository repository;
    private final VideoEntityMapper mapper;

    @Override
    public List<Video> getAllVideosByCategory(Long id) {
        final var videos = repository.getVideoEntitiesByCategoryId(id);
        return videos.map(videoEntities -> videoEntities
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList()))
                .orElseGet(List::of);
    }
}
