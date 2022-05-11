package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public String getFormRegister(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    
}
