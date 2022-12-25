package com.example.demo.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.models.Students;

import reactor.core.publisher.Flux;

public interface StudentsRepository extends ReactiveMongoRepository<Students, Integer> {

	  @Query("{ 'name': ?0 }")
	  Flux<Students> findByName(final String name);
	}
