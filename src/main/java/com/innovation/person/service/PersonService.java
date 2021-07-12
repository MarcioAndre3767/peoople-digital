package com.innovation.person.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovation.person.dto.request.PersonDTO;
import com.innovation.person.dto.response.MessageResponseDTO;
import com.innovation.person.entity.Person;
import com.innovation.person.exception.PersonNotFoundException;
import com.innovation.person.mapper.PersonMapper;
import com.innovation.person.repository.PersonRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse("Created person with ID: ", savedPerson.getId());
	}

	
	
	// buscar todos

	public List<PersonDTO> listAll() {
		 List<Person> allPeople = personRepository.findAll();

		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	
	
	// buscar id
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);


		return personMapper.toDTO(person);
	}
	
	// atualizar
	
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		
		
		Person personToUpdate = personMapper.toModel(personDTO);
		
		Person updatePerson = personRepository.save(personToUpdate);
		return createMessageResponse("Update person with ID: ", updatePerson.getId());
	}



	
	// deletar
	
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		
		personRepository.deleteById(id);
	}

	
	
	//método verificar existência
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	
	//método message response
	
	private MessageResponseDTO createMessageResponse(String message, Long id) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}


	

}










