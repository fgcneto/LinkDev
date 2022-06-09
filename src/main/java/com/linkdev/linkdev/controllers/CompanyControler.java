package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.services.CompanyService;
import com.linkdev.linkdev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

<<<<<<< HEAD
    @RequestMapping({"/", "/index"})
    public String getPageUsuario(Model model,  HttpServletRequest request, HttpServletResponse response){
        List<Company> companyList = service.findAll();
        model.addAttribute("company", companyList);
        Date dataDaSessao = new Date();
        var dataDoAcesso = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        var dataFormatada = dataDoAcesso.format(dataDaSessao);
        Cookie biscoito = new Cookie("usuario", dataFormatada);
        biscoito.setMaxAge(86400);
        response.addCookie(biscoito);
=======
    @RequestMapping({"/", "/indexDev"})
    public String getPageUsuario(Model model){
        List<Company> companyList = service.findAll();
        model.addAttribute("company", companyList);
>>>>>>> 9267978f8269298c718aee242fd8bfcf3eb49f34
        return "indexDev";
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
            return "redirect:/register";
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
