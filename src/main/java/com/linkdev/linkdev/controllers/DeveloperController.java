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
        //User user = new User();
        //model.addAttribute("user",user);
        Developer dev = new Developer();
        model.addAttribute("dev",dev);
        return "dev";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSaveDeveloper(@ModelAttribute @Valid Developer dev, User user, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/dev";
        }else{
            //userService.save(user);
            developerService.add(dev);
            return "redirect:/register";
        }

    }


/*
    @GetMapping
    public List<Developer> listAll(){
        return developerService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Developer> getOne(@PathVariable Long id) {
        Optional<Developer> developer = developerService.findByid(id);
        if(developer.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Developer record =  developer.get();
            return ResponseEntity.ok().body(record);
        }
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Developer> Entityupdate(@PathVariable Long id, @RequestBody Developer developer) {
        return developerService.findByid(id).map( record -> {
            developerService.add(developer);
            return ResponseEntity.ok().body(developer);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Developer insert(@RequestBody Developer developer) {
        return developerService.add(developer);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return developerService.findByid(id).map(record ->{
             developerService.delete(record);
            return ResponseEntity.status(202).build();
        }).orElse(ResponseEntity.notFound().build());
    }
 */

}
