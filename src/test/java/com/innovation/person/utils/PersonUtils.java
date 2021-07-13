package com.innovation.person.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.innovation.person.dto.request.PersonDTO;
import com.innovation.person.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Márcio";
	private static final String LAST_NAME = "Mendes";
	private static final String CPF_NUMBER = "523.648.762.-57";
	private static final long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(1979, 10, 25);
	
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate("1979-10-25")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
				
	}
	
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
	
	
	

}







