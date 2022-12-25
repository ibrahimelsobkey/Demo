package com.example.demo.service;

import com.example.demo.models.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStudentsService

{
  void create(Students e);
   
  Mono<Students> findById(Integer id);
 
  Flux<Students> findByName(String name);
 
  Flux<Students> findAll();
 
  Mono<Students> update(Students e);
 
  Mono<Void> delete(Integer id);
}