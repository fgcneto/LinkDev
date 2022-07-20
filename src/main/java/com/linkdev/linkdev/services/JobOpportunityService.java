package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.models.JobOpportunity;
import com.linkdev.linkdev.repository.DeveloperRepository;
import com.linkdev.linkdev.repository.JobOpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOpportunityService {

    private JobOpportunityRepository jobOpportunityRepository;

    @Autowired
    public void setJobOpportunityRepository(JobOpportunityRepository jobOpportunityRepository){
        this.jobOpportunityRepository = jobOpportunityRepository;
    }

    public JobOpportunity add(JobOpportunity jobOpportunity) {
        return jobOpportunityRepository.save(jobOpportunity);
    }

    public void delete(Long id) {
        jobOpportunityRepository.deleteById(id);
    }

    public Optional<JobOpportunity> findByid(Long id) {
        return jobOpportunityRepository.findById(id);
    }
    public List<JobOpportunity> findAll() {
        return jobOpportunityRepository.findAll();
    }
}
