package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Corporation;

public interface CorporationRepo extends JpaRepository<Corporation, Integer> {
    
}
