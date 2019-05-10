package com.jonny.controller;

import com.jonny.service.CommonModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    private final CommonModelService service;

    @Autowired
    public CommonController(CommonModelService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String readAll(ModelMap modelMap){
        service.readAll(modelMap);
        return "main/all";
    }
}