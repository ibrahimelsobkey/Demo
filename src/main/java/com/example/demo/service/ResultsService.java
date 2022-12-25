package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ResultsRepository;
import com.example.demo.models.Results;
import com.example.demo.models.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class ResultsService implements IResultsService {
	@Autowired
	ResultsRepository resultsRepository; 
	
	@Override
	public void create(Results e) {
		resultsRepository.save(e).subscribe();
	}

	@Override
	public Mono<Results> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Results> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Results> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Results> update(Results e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}}