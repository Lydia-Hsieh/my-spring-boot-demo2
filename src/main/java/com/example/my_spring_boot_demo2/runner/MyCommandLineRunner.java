package com.example.my_spring_boot_demo2.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/replicate";
        try {
            restTemplate.getForEntity(url, ResponseEntity.class);
        } catch (RestClientException e) {
            log.error("Exception {} happened in CommandLine Runner: {}", e.getClass(), e.getMessage());
        }
        SpringApplication.exit(context, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }
}
