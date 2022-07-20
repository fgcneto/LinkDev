package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.models.JobOpportunity;
import com.linkdev.linkdev.services.CompanyService;
import com.linkdev.linkdev.services.JobOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        if(errors.hasErrors()){
            return "redirect:/job";
        }else{
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
