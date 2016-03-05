package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.domain.PersonToChoreReward;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by Jason on 2/21/2016.
 */
@Controller
public class ChoreRewardForPersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ChoreRewardRepository choreRewardRepository;

    @RequestMapping("/chorerewardforperson")
    public String chorerewardforperson(@RequestParam(value="personid", required=true) Long personId, Model model, Principal principal) {
        Person person = personRepository.findById(personId);
        int totalPoints = 0;
        for (PersonToChoreReward personToChoreReward : person.getPersonToChoreRewardList()) {
            totalPoints += personToChoreReward.getChoreReward().getPoints();
        }
        model.addAttribute(person);
        model.addAttribute("totalPoints", totalPoints);
        model.addAttribute("loggedIn", principal != null);
        return "chorerewardforperson";
    }
}
