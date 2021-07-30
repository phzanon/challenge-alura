package com.freemanpivo.chassi.h2.repository;

import com.freemanpivo.chassi.h2.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoEntityRepository extends JpaRepository<VideoEntity, Long> {
    Optional<List<VideoEntity>> getVideoEntitiesByCategoryId(Long id);
}
