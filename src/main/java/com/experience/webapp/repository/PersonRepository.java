package com.experience.webapp.repository;

import com.experience.webapp.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findBySurname(String surname);
}
