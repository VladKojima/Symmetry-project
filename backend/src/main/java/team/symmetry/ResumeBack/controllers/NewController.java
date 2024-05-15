package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.New.NewDTO;
import team.symmetry.ResumeBack.models.New;
import team.symmetry.ResumeBack.services.NewService;
import team.symmetry.ResumeBack.services.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/new")
@CrossOrigin
public class NewController {
    @Autowired
    NewService newService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<New> getAll(@RequestParam String param) {
        return newService.getAll();
    }
    
    
    @PostMapping
    public New create(@RequestBody NewDTO dto) {
        return newService.create(roleService.getId(), dto);
    }
    
}
