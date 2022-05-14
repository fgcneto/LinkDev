package com.linkdev.linkdev.controllers;

import com.linkdev.linkdev.models.Skill;
import com.linkdev.linkdev.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/skill")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public void setSkillService(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> listAll(){
        return skillService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Skill> getOne(@PathVariable Long id) {
        Optional<Skill> skill = skillService.findById(id);
        if(skill.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Skill record =  skill.get();
            return ResponseEntity.ok().body(record);
        }
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Skill> Entityupdate(@PathVariable Long id, @RequestBody Skill skill) {
        return skillService.findById(id).map( record -> {
            skillService.save(skill);
            return ResponseEntity.ok().body(skill);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Skill insert(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return skillService.findById(id).map(record ->{
            skillService.delete(record);
            return ResponseEntity.status(202).build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
