package com.freemanpivo.chassi.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.freemanpivo.chassi"})
@EntityScan(basePackages = {"com.freemanpivo.chassi.h2"})
@EnableJpaRepositories(basePackages = {"com.freemanpivo.chassi.h2"})
public class AluraChallengeApplication {

    public static void main(String[] args) {

        SpringApplication.run(AluraChallengeApplication.class);
    }
}
