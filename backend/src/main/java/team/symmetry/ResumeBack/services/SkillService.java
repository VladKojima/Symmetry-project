package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Skill.SkillDTO;
import team.symmetry.ResumeBack.models.Skill;
import team.symmetry.ResumeBack.repos.SkillRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class SkillService {
    @Autowired
    EntityValidator validator;

    @Autowired
    SkillRepo skillRepo;

     public List<Skill> getAll(){
        return skillRepo.findAll();
    }

    public Skill create(SkillDTO dto){
        validator.validate(dto);

        return skillRepo.save(new Skill(null, dto.getName(), null));
    }
}
