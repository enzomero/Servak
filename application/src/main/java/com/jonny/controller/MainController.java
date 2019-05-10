package com.jonny.controller;

import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.Person;
import com.jonny.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/main")
public class MainController {

    @Autowired
    private CommonService commonService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Person> readAll() {
        return commonService.readAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Person getById(@PathVariable Integer id) throws NotFoundExeption{
        return commonService.getById(id);
    }
 }
