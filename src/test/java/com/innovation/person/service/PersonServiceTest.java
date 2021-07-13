package com.innovation.person.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.innovation.person.dto.request.PersonDTO;
import com.innovation.person.dto.response.MessageResponseDTO;
import com.innovation.person.entity.Person;
import com.innovation.person.repository.PersonRepository;

import static com.innovation.person.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	
	@Mock
	private PersonRepository personRepository;
	
	
	@InjectMocks
	private PersonService personService;
	
	
	@Test
	void testGivanPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccesMessage = MessageResponseDTO
														.builder()
														.message("Create person whith ID: " + expectedSavedPerson.getId())
														.build();
		
		MessageResponseDTO succesMessage = personService.createPerson(personDTO);
		
		assertEquals(expectedSuccesMessage, succesMessage);
		
	}
	
	
	
	

}








