package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Skill.SkillDTO;
import team.symmetry.ResumeBack.models.Skill;
import team.symmetry.ResumeBack.services.SkillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/skill")
@CrossOrigin
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @PostMapping
    public Skill create(@RequestBody SkillDTO entity) {
       
        return skillService.create(entity);
    }
    
}
