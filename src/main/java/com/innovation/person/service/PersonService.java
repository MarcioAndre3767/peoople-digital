package com.innovation.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovation.person.dto.request.PersonDTO;
import com.innovation.person.dto.response.MessageResponseDTO;
import com.innovation.person.entity.Person;
import com.innovation.person.mapper.PersonMapper;
import com.innovation.person.repository.PersonRepository;



@Service
public class PersonService {
	
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	
	
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();
	}
	
	
	

}










