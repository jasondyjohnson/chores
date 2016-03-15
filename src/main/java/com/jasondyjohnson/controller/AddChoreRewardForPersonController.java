package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.domain.PersonToChoreReward;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.PersonRepository;
import com.jasondyjohnson.repository.PersonToChoreRewardRepository;
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
 * Created by Jason on 3/14/2016.
 */
@Controller
public class AddChoreRewardForPersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ChoreRewardRepository choreRewardRepository;
    @Autowired
    PersonToChoreRewardRepository personToChoreRewardRepository;

    @RequestMapping(value="/addchorerewardforperson", method= RequestMethod.GET)
    public String addChoreRewardForPerson(@RequestParam(value="personid", required=true) Long personId,
                                          @RequestParam(value="addChore", required=true) Boolean addChore,
                                          Model model, Principal principal) {
        PersonToChoreReward personToChoreReward = new PersonToChoreReward(personRepository.findById(personId), null, new Date());
        Person person = personRepository.findById(personId);
        model.addAttribute("chorePerson", person);
        model.addAttribute("personToChoreReward", personToChoreReward);
        model.addAttribute("addChore", addChore);
        if (addChore) {
            model.addAttribute("allChoreRewards", choreRewardRepository.findAllChoresOrderByNameAsc());
        }
        else {
            model.addAttribute("allChoreRewards", choreRewardRepository.findAllRewardsOrderByNameAsc());
        }
        return "addchorerewardforperson";
    }

    @RequestMapping(value="/addchorerewardforperson", method=RequestMethod.POST)
    public String saveChoreRewardForPerson(@ModelAttribute PersonToChoreReward personToChoreReward, Model model) {
        personToChoreRewardRepository.save(personToChoreReward);
        return "redirect:/chorerewardforperson?personid=" + Long.toString(personToChoreReward.getPerson().getId());
    }
}
