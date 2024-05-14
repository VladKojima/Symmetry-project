package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
    
}
