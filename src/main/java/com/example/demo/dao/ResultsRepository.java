
package com.example.demo.dao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.models.Results;

import reactor.core.publisher.Flux;

public interface ResultsRepository extends ReactiveMongoRepository<Results, Integer> {

	  @Query("{ 'name': ?0 }")
	  Flux<Results> findByName(final String name);
	}
