package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Results;
import com.example.demo.service.ResultsService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
public class ResultsController {

  @Autowired
  private ResultsService resultsService;
 
  @RequestMapping(value = { "/createResults"}, method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody @Valid Results e) {
	  resultsService.create(e);
  }
  
 }