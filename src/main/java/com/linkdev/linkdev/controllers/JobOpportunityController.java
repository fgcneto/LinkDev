package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.models.JobOpportunity;
import com.linkdev.linkdev.services.CompanyService;
import com.linkdev.linkdev.services.JobOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class JobOpportunityController {

    private JobOpportunityService jobOpportunityService;
    private CompanyService companyService;
    private Company company;

    @Autowired
    public void setJobOpportunityService(JobOpportunityService jobOpportunityService) {
        this.jobOpportunityService = jobOpportunityService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/job")
    public String getFormVagas(Model model){
        JobOpportunity jobOpportunity = new JobOpportunity();
        model.addAttribute("job",jobOpportunity);
        return "job";
    }

    @RequestMapping(value = "/addjob", method = RequestMethod.POST)
    public String doSaveCompany(@ModelAttribute @Valid JobOpportunity jobOpportunity, Errors errors){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        Company company = companyService.findByUsername(username);
        
        if(errors.hasErrors()){
            return "redirect:/job";
        }else{
            jobOpportunity.setCompany(company);
            jobOpportunityService.add(jobOpportunity);
            return "redirect:/";
        }
    }

    @RequestMapping("/editar")
    public String getEditar(Model model) {
        List<Company> companyList = companyService.findAll();
        model.addAttribute("company", companyList);
        List<JobOpportunity> jobOpportunityList = jobOpportunityService.findAll();
        model.addAttribute("vaga", jobOpportunityList);
        return "editar";
    }

    @RequestMapping("/delete/{id}")
    public String doDelete(@PathVariable(name = "id") Long id){
        jobOpportunityService.delete(id);
        return "redirect:/";
    }

}
