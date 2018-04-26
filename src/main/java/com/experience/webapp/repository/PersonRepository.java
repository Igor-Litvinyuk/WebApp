package com.experience.webapp.repository;

import com.experience.webapp.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
