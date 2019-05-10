package com.jonny.controller;

import com.jonny.PersonDao;
import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/main")
public class MainController {

    @Autowired
    public PersonDao personDao;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Person> readAll() {
        return personDao.findAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Person getById(@PathVariable Integer id){
        return personDao.findById(id).orElseThrow(NotFoundExeption::new);
    }
 }
