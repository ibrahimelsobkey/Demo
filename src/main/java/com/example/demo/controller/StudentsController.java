package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Students;
import com.example.demo.service.StudentsService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentsController {

  @Autowired
  private StudentsService studentsService;
 
  @RequestMapping(value = { "/create"}, method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody @Valid Students e) {
	  studentsService.create(e);
  }
  
  @RequestMapping(value = "/delete", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public Mono<Students> update(@RequestBody Students e) {
    return studentsService.update(e);
  }
  
  @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Students> getStudents() {
    return studentsService.findAll();
  }
  
  
}