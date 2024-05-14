package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer>{
    
}
