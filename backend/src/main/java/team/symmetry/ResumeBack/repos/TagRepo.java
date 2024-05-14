package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Tag;

public interface TagRepo extends JpaRepository<Tag, Integer> {
    
}
