package team.symmetry.ResumeBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Student.Profile;
import team.symmetry.ResumeBack.dto.Student.RegisterInfo;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.services.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable("id") Integer id) {

        return studentService.getProfile(id);
    }

    @PutMapping("/{id}")
    public void editProfile(
        // @RequestBody Profile profile, 
        Authentication auth) {
        System.out.println(auth.getName());
    }

    @PostMapping
    public Student create(RegisterInfo info) {

        
        return studentService.create(info);
    }
    
    

}
