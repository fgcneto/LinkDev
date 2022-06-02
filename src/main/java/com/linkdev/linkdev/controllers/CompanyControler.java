package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.services.CompanyService;
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
//@RequestMapping("/company")
@Controller
public class CompanyControler {

    private CompanyService service;
    private UserService userService;

    @Autowired
    public void setService(CompanyService service) {
        this.service = service;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"/", "/index"})
    public String getPageUsuario(Model model){
        List<Company> companyList = service.findAll();
        model.addAttribute("company", companyList);
        //User aux = new User();  //
        //aux = userService.getById(); // devolver nome do user na tela
        return "index";
    }


    @RequestMapping("/company")
    public String getFormCompany(Model model){
        Company company = new Company();
        model.addAttribute("company",company);
        return "company";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String doSaveCompany(@ModelAttribute @Valid Company company, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/company";
        }else{
            service.add(company);
            return "redirect:/login";
        }

    }

    /*
    @GetMapping
    public List<Company> listAll(){
        return companyService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Company> getOne(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        if(company.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Company record =  company.get();
            return ResponseEntity.ok().body(record);
        }
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Company> Entityupdate(@PathVariable Long id, @RequestBody Company company) {
        return companyService.findById(id).map( record -> {
            companyService.add(company);
            return ResponseEntity.ok().body(company);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company insert(@RequestBody Company company) {
        return companyService.add(company);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return companyService.findById(id).map(record ->{
            companyService.delete(record);
            return ResponseEntity.status(202).build();
        }).orElse(ResponseEntity.notFound().build());
    }
    */
}
