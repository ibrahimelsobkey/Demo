package com.example.demo.service;

import com.example.demo.models.Results;
import com.example.demo.models.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IResultsService

{
  void create(Results e);
   
  Mono<Results> findById(Integer id);
 
  Flux<Results> findByName(String name);
 
  Flux<Results> findAll();
 
  Mono<Results> update(Results e);
 
  Mono<Void> delete(Integer id);
}