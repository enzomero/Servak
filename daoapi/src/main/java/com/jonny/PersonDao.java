package com.jonny;

import com.jonny.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonDao extends CrudRepository<Person, Integer> {

}
