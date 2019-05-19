package com.jonny.controller;

import com.jonny.viewservice.RegistarationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistartionController {

    @Autowired
    private RegistarationModelService service;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "registarion", method = RequestMethod.POST)
    public String registarion(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "loginname") String loginname,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "active") String active
    ){
        if(id.equals(""))
            id="0";
        service.save(Integer.valueOf(id),username, loginname, password, active);
        return "redirect:login";
    }
}
