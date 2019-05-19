package com.jonny.controller;

import com.jonny.UserRepo;
import com.jonny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/registration")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("{username}")
    public User addUser(@PathVariable String username){
        return userRepo.findByUserName(username);
    }
}
