package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.ChoreReward;
import com.jasondyjohnson.domain.PersonToChoreReward;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by Jason on 7/4/2016.
 */
@Controller
public class AddChoreRewardController {
    @Autowired
    ChoreRewardRepository choreRewardRepository;

    @RequestMapping(value="/addchorereward", method= RequestMethod.GET)
    public String addChoreRewardForPerson(Model model, Principal principal) {
        ChoreReward choreReward = new ChoreReward("New Reward", 0);
        model.addAttribute(choreReward);
        return "addchorereward";
    }

    @RequestMapping(value="/addchorereward", method=RequestMethod.POST)
    public String saveChoreRewardForPerson(@ModelAttribute ChoreReward choreReward, Model model) {
        choreRewardRepository.save(choreReward);
        return "redirect:/index";
    }
}
