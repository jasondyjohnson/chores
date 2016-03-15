package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2/20/2016.
 */
@Controller
public class IndexController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value="/")
    public String index(){
        return "redirect:/index.html";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        Iterable<Person> usersIterable = personRepository.findAllByOrderByFirstNameAsc();
        List<Person> persons = new ArrayList<>();
        for (Person person : usersIterable) {
            persons.add(person);
        }
        model.addAttribute("persons", persons);
        model.addAttribute("personCount", persons.size());
        return "index";
    }

}
