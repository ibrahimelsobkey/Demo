package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.Students;

import reactor.core.publisher.Mono;

public class StudentsResultClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentsResultClient.class);
    
    WebClient client = WebClient.create("http://localhost:8090");
    
    public void consume() {

           client.post()
          .uri("/create", "1")
          .retrieve()
          .bodyToMono(Void.class);


        Mono<Students> updatedStudent = client.put()
          .uri("/delete")
          .retrieve()
          .bodyToMono(Students.class);

        updatedStudent.subscribe(employee -> LOGGER.info("updatedStudent: {}", updatedStudent));
    }


}
