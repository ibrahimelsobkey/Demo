package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.example.demo.controller.ResultsController;
import com.example.demo.dao.ResultsRepository;
import com.example.demo.models.Results;
import com.example.demo.service.ResultsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebFluxWebSocketHandler implements WebSocketHandler {

	@Autowired
	private ResultsRepository resultsRepository;

	@Autowired
	ResultsController rest;
	
	private static final ObjectMapper json = new ObjectMapper();

	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession){
		Flux<WebSocketMessage> stringFlux=null;
		
		  stringFlux = webSocketSession.receive()
		  .map(WebSocketMessage::getPayloadAsText)
		  .map(e->{
			try {
				return json.readValue(e, Results.class);
			} catch (JsonMappingException e2) {
				e2.printStackTrace();
			} catch (JsonProcessingException e2) {
				e2.printStackTrace();
			}
			return null;
		})
		  .map(m->resultsRepository.save(m).subscribe())
		  .map(m->{
			try {
				return json.writeValueAsString(m);
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
			return null;
		})
		  .map(String::toUpperCase) 
		  .map(webSocketSession::textMessage);  
		  
		  Flux<WebSocketMessage> stringFlux2 = webSocketSession.receive()
				  .map(WebSocketMessage::getPayloadAsText)
				  .map(e->e="").map(m->m.concat("Saved"))
				  .map(webSocketSession::textMessage);
		  
		  return webSocketSession.send(stringFlux);						

	}

}
