package com.innovation.person.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.person.dto.request.PersonDTO;
import com.innovation.person.dto.response.MessageResponseDTO;
import com.innovation.person.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	

	private PersonService personService;
	
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		
		return personService.createPerson(personDTO);
		
	}

}









