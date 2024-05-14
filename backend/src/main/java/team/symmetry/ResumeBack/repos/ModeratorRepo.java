package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Moderator;

public interface ModeratorRepo extends JpaRepository<Moderator, Integer> {
    
}
