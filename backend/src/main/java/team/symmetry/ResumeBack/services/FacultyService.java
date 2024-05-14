package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Faculty.FacultyDTO;
import team.symmetry.ResumeBack.models.Faculty;
import team.symmetry.ResumeBack.repos.FacultyRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class FacultyService {
    @Autowired
    FacultyRepo facultyRepo;

    @Autowired
    EntityValidator validator;

    public List<Faculty> getAll() {
        return facultyRepo.findAll();
    }

    public Faculty create(FacultyDTO dto) {
        validator.validate(dto);

        return facultyRepo.save(
                Faculty.builder()
                        .name(dto.getName())
                        .university(dto.getUniversity())
                        .build());
    }
}
