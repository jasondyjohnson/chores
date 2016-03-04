package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.User;
import com.jasondyjohnson.domain.UserToChoreReward;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jason on 2/21/2016.
 */
@Controller
public class ChoreRewardForUserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChoreRewardRepository choreRewardRepository;

    @RequestMapping("/chorerewardforuser")
    public String chorerewardforuser(@RequestParam(value="userid", required=true) Long userid, Model model) {
        User user = userRepository.findById(userid);
        int totalPoints = 0;
        for (UserToChoreReward userToChoreReward : user.getUserToChoreRewardList()) {
            totalPoints += userToChoreReward.getChoreReward().getPoints();
        }
        model.addAttribute(user);
        model.addAttribute("totalPoints", totalPoints);
        return "chorerewardforuser";
    }
}
