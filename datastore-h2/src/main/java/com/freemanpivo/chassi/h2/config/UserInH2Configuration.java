package com.freemanpivo.chassi.h2;

import com.freemanpivo.chassi.h2.entity.UserEntity;
import com.freemanpivo.chassi.h2.entity.VideoEntity;
import com.freemanpivo.chassi.h2.repository.UserEntityRepository;
import com.freemanpivo.chassi.h2.repository.VideoEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserInH2Configuration {

    @Bean
    public CommandLineRunner loadData(UserEntityRepository repository) {
        return args -> {
            repository.save(new UserEntity(1L,"Alambrado Amaral", LocalDate.parse("1990-01-01")));
            repository.save(new UserEntity(2L,"Beltrano Bezerra", LocalDate.parse("1991-02-02")));
        };
    }

    @Bean
    public CommandLineRunner loadDataVideo(VideoEntityRepository repository) {
        return args -> {
            repository.save(new VideoEntity("abc", "Pedro", "Descrição", "url://"));
            repository.save(new VideoEntity("123", "Duro de matar", "Descrição", "url://"));
            repository.save(new VideoEntity("234cde", "Duro de Matar 2", "Descrição", "url://"));
        };
    }
}
