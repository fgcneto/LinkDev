package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;

    @Autowired
    public void setDeveloperRepository(DeveloperRepository developerRepository){
        this.developerRepository = developerRepository;
    }

    public Developer add(Developer developer) {
        return developerRepository.save(developer);
    }
    public Developer update(Developer developer) {
        return developerRepository.save(developer);
    }
    public void delete(Developer developer) {
        developerRepository.delete(developer);
    }
    public void deleteByid(Long id) {
        developerRepository.deleteById(id);
    }
    public Developer findOne(Long id) {
        return developerRepository.findById(id).orElse(null);
    }
    public Optional<Developer> findByid(Long id) {
        return developerRepository.findById(id);
    }
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }
}
