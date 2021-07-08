package com.innovation.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovation.person.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
