package com.jonny.service.impl;

import com.jonny.UserRepo;
import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.User;
import com.jonny.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserRepo personRepo;

    public Iterable<User> readAll() {
        return personRepo.findAll();
    }

    public User getById(Integer id) {
        return personRepo.findById(id).orElseThrow(NotFoundExeption::new);
    }
}
