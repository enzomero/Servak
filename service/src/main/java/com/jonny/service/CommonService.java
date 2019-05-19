package com.jonny.service;

import com.jonny.exeptions.NotFoundExeption;
import com.jonny.model.User;

public interface CommonService {
    public User getById(Integer id) throws NotFoundExeption;

    public Iterable<User> readAll();
}
