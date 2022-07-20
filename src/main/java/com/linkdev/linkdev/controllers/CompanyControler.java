package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.models.JobOpportunity;
import com.linkdev.linkdev.services.CompanyService;
import com.linkdev.linkdev.services.JobOpportunityService;
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
    private JobOpportunityService jobOpportunityService;

    @Autowired
    public void setService(CompanyService service) {
        this.service = service;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setJobOpportunityService(JobOpportunityService jobOpportunityService) {
        this.jobOpportunityService = jobOpportunityService;
    }

    @RequestMapping({"/", "/index"})
    public String getPageUsuario(Model model,  HttpServletRequest request, HttpServletResponse response){
        List<Company> companyList = service.findAll();
        model.addAttribute("company", companyList);
        List<JobOpportunity> jobOpportunityList = jobOpportunityService.findAll();
        model.addAttribute("vaga", jobOpportunityList);
        Date dataDaSessao = new Date();
        var dataDoAcesso = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        var dataFormatada = dataDoAcesso.format(dataDaSessao);
        Cookie biscoito = new Cookie("usuario", dataFormatada);
        biscoito.setMaxAge(86400);
        response.addCookie(biscoito);
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
            return "redirect:/login";
        }

    }

    @RequestMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }

}
