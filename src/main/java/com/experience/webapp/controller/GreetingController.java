package com.experience.webapp.controller;

import com.experience.webapp.model.Person;
import com.experience.webapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Person> contacts = personRepository.findAll();
        model.put("contacts", contacts);
        return "main";
    }

    @PostMapping
    public String addContact(@RequestParam String name, @RequestParam String surname, @RequestParam String phoneNumber, Map<String, Object> model){
        Person person = new Person(name, surname, phoneNumber);
        personRepository.save(person);
        Iterable<Person> contacts = personRepository.findAll();
        model.put("contacts", contacts);
        return "main";
    }

    @PostMapping("nameFilter")
    public String nameFilter(@RequestParam String nameFilter, Map<String, Object> model){
        Iterable<Person> contacts;
        if(nameFilter != null && !nameFilter.isEmpty()){
            contacts = personRepository.findByName(nameFilter);
        }
        else {
            contacts = personRepository.findAll();
        }
        model.put("contacts", contacts);
        return "main";
    }

    @PostMapping("surnameFilter")
    public String surnameFilter(@RequestParam String surnameFilter, Map<String, Object> model){
        Iterable<Person> contacts;
        if(surnameFilter != null && !surnameFilter.isEmpty()){
            contacts = personRepository.findBySurname(surnameFilter);
        }
        else {
            contacts = personRepository.findAll();
        }
        model.put("contacts", contacts);
        return "main";
    }
}