package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Department.DepartmentDTO;
import team.symmetry.ResumeBack.models.Department;
import team.symmetry.ResumeBack.repos.DepartmentRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    EntityValidator validator;

    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    public Department create(DepartmentDTO entity) {
        validator.validate(entity);

        return departmentRepo.save(Department.builder()
                .faculty(entity.getFaculty())
                .name(entity.getName()).build());
    }
}
