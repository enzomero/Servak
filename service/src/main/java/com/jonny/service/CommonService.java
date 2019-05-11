package com.jonny.service;

import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.Person;

public interface CommonService {
    public Iterable<Person> readAll();

    public Person getById(Integer id) throws NotFoundExeption;
}
