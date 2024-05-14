package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Competition;

public interface CompetitionRepo extends JpaRepository<Competition, Integer> {
    
}
