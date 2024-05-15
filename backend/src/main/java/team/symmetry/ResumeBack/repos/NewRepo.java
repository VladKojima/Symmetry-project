package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.New;

public interface NewRepo extends JpaRepository<New, Integer> {
    
}
