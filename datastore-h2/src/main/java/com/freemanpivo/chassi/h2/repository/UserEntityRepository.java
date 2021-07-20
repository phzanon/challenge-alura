package com.freemanpivo.chassi.h2.repository;

import com.freemanpivo.chassi.h2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> { }
