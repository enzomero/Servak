package com.jonny.controller;

import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.Person;
import com.jonny.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
