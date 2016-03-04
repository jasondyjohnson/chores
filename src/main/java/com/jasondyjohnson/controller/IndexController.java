package com.jasondyjohnson.controller;

import com.jasondyjohnson.domain.User;
import com.jasondyjohnson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2/20/2016.
 */
@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (User user : usersIterable) {
            users.add(user);
        }
        model.addAttribute("users", users);
        model.addAttribute("userCount", users.size());
        return "index";
    }

}
