package com.example.demo_curso_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class DemoCursoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCursoJpaApplication.class, args);
    }

}
