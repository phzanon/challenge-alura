package com.freemanpivo.chassi.h2.repository;

import com.freemanpivo.chassi.h2.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoEntityRepository extends JpaRepository<VideoEntity, String> {
}
