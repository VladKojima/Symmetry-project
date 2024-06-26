package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Faculty.FacultyDTO;
import team.symmetry.ResumeBack.models.Faculty;
import team.symmetry.ResumeBack.services.FacultyService;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping
    public List<Faculty> getAll(){
        return facultyService.getAll();
    }
    
    @PostMapping("/create")
    public Faculty create(@RequestBody FacultyDTO dto){
        return facultyService.create(dto);
    }
}
