package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Student.Profile;
import team.symmetry.ResumeBack.dto.Student.QuickProfile;
import team.symmetry.ResumeBack.dto.Student.RegisterInfo;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.services.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<QuickProfile> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable("id") Integer id) {

        return studentService.getProfile(id);
    }

    @PostMapping
    public Student create(@RequestBody RegisterInfo info) {

        return studentService.create(info);
    }

}
