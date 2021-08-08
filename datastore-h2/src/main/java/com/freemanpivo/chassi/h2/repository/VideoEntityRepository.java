package com.freemanpivo.chassi.h2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freemanpivo.chassi.h2.entity.VideoEntity;

public interface VideoEntityRepository extends JpaRepository<VideoEntity, Long> {
	Optional<List<VideoEntity>> getVideoEntitiesByCategoryId(Long id);

	Optional<VideoEntity> findVideoEntityByTitulo(String titulo);
}
