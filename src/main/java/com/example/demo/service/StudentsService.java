package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentsRepository;
import com.example.demo.models.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentsService implements IStudentsService
{

	@Autowired
	StudentsRepository studentsRepository;
	
	@Override
	public void create(Students student) {
		studentsRepository.save(student).subscribe();
	}

	@Override
	public Mono<Students> findById(Integer id) {
		return null;
	}

	@Override
	public Flux<Students> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Students> findAll() {
		return studentsRepository.findAll();
	}

	@Override
	public Mono<Students> update(Students e) {
		e.setStatus("Deleted");
	    return studentsRepository.save(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
  
}