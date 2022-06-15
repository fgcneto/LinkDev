package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.services.DeveloperService;
import com.linkdev.linkdev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@RestController
//@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
//@RequestMapping("/developer")
@Controller
public class DeveloperController {

    private DeveloperService developerService;

    @Autowired
    public void setDeveloperService(DeveloperService developerService) {
        this.developerService = developerService;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/dev")
    public String getFormDeveloper(Model model){
        Developer dev = new Developer();
        model.addAttribute("dev",dev);
        return "dev";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSaveDeveloper(@ModelAttribute @Valid Developer dev, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/dev";
        }else{
            developerService.add(dev);
            return "redirect:/login";
        }

    }
}
