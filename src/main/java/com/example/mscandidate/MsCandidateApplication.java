package com.example.mscandidate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication


public class MsCandidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCandidateApplication.class, args);
    }
    @Bean
    ApplicationRunner init(CandidatRepository repository) {
        return args -> {
            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
                repository.save(new Candidat(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
