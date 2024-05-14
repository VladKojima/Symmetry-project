package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Skill;

public interface SkillRepo extends JpaRepository<Skill, Integer>{
    
}
