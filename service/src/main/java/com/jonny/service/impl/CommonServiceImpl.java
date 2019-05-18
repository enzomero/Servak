package com.jonny.service.impl;

import com.jonny.PersonRepo;
import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.Person;
import com.jonny.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private PersonRepo personRepo;

    public Iterable<Person> readAll() {
        return personRepo.findAll();
    }

    public Person getById(Integer id) {
        return personRepo.findById(id).orElseThrow(NotFoundExeption::new);
    }
}
