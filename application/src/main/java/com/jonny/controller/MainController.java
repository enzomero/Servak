package com.jonny.controller;


import com.jonny.dao_api.PersonDao;
import com.jonny.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping(path ="/main")
public class MainController {
    @Autowired
    private PersonDao personDao;

    public @ResponseBody String home(){
        return "index";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewPerson(@RequestParam String name){
        Person p = new Person();
        p.setName(name);
        personDao.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personDao.findAll();
    }
}
