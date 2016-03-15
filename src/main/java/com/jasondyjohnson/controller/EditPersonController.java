package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.domain.PersonToChoreReward;
import com.jasondyjohnson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

/**
 * Created by Jason on 3/15/2016.
 */
@Controller
public class EditPersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value="/editperson", method= RequestMethod.GET)
    public String addChoreRewardForPerson(@RequestParam(value="personid", required=true) Long personId,
                                          Model model, Principal principal) {
        Person person = personRepository.findById(personId);
        model.addAttribute("chorePerson", person);
        return "editperson";
    }

    @RequestMapping(value="/editperson", method=RequestMethod.POST)
    public String saveChoreRewardForPerson(@ModelAttribute Person chorePerson, Model model) {
        Person existingPerson = personRepository.findById(chorePerson.getId());
        existingPerson.setLoginName(chorePerson.getLoginName());
        existingPerson.setFirstName(chorePerson.getFirstName());
        existingPerson.setLastName(chorePerson.getLastName());
        existingPerson.setEmail(chorePerson.getEmail());
        existingPerson.setImageFileUrl(chorePerson.getImageFileUrl());
        personRepository.save(existingPerson);
        return "redirect:/chorerewardforperson?personid=" + Long.toString(existingPerson.getId());
    }
}
