package com.jonny.controller;

import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.User;
import com.jonny.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/main")
public class MainController {

    @Autowired
    private CommonService commonService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> readAll() {
        return commonService.readAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody
    User getById(@PathVariable Integer id) throws NotFoundExeption{
        return commonService.getById(id);
    }
 }
