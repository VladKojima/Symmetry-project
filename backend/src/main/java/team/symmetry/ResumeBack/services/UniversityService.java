package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.University.UniversityDTO;
import team.symmetry.ResumeBack.models.University;
import team.symmetry.ResumeBack.repos.UniversityRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class UniversityService {
    @Autowired
    UniversityRepo universityRepo;

    @Autowired
    EntityValidator validator;

    public List<University> getAll() {
        return universityRepo.findAll();
    }

    public University create(UniversityDTO dto) {
        validator.validate(dto);

        return universityRepo.save(
                University.builder()
                        .name(dto.getName())
                        .build());
    }
}
