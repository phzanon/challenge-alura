package com.freemanpivo.chassi.h2.config;

import com.freemanpivo.chassi.h2.entity.CategoryEntity;
import com.freemanpivo.chassi.h2.entity.VideoEntity;
import com.freemanpivo.chassi.h2.repository.CategoryEntityRepository;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInH2Configuration {

    @Bean
    public CommandLineRunner loadDataCategory(CategoryEntityRepository repository) {
        return args -> {
            repository.save(new CategoryEntity(1L, "LIVRE", "AZUL"));
        };
    }

    @Bean
    public CommandLineRunner loadDataVideo(VideoEntityRepository repository) {
        return args -> {
            repository.save(new VideoEntity(1L, new CategoryEntity(1L, "LIVRE", "AZUL"), "Pedro", "Descrição", "url://"));
            repository.save(new VideoEntity(2L, new CategoryEntity(1L, "LIVRE", "AZUL"), "Duro de matar", "Descrição", "url://"));
            repository.save(new VideoEntity(3L, new CategoryEntity(1L, "LIVRE", "AZUL"), "Duro de Matar 2", "Descrição", "url://"));
        };
    }
}
