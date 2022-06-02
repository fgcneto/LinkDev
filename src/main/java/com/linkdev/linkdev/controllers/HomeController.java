package com.linkdev.linkdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "indexDev";
    }

    @RequestMapping("/choose")
    public String choose(){
        return "choose";
    }

}
