package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Skill;
import com.linkdev.linkdev.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private SkillRepository skillRepository;


    @Autowired
    public void setCompanyRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public void delete(Skill skill) {
        skillRepository.delete(skill);
    }

    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
}
