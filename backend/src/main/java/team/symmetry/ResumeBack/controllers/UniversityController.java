package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.University.UniversityDTO;
import team.symmetry.ResumeBack.models.University;
import team.symmetry.ResumeBack.services.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/university")
@CrossOrigin
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping
    public List<University> getAll() {
        return universityService.getAll();
    }

    @PostMapping
    public University create(@RequestBody UniversityDTO dto){
        return universityService.create(dto);
    }    
}
