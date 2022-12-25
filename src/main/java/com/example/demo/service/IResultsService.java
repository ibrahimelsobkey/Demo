package com.example.demo.service;

import com.example.demo.models.Results;
import com.example.demo.models.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IResultsService

{
  void create(Results e);
   
  Mono<Students> findById(Integer id);
 
  Flux<Students> findByName(String name);
 
  Flux<Students> findAll();
 
  Mono<Students> update(Results e);
 
  Mono<Void> delete(Integer id);
}