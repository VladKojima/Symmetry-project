package team.symmetry.ResumeBack.controllers;

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


@RestController
@RequestMapping("/api/new")
@CrossOrigin
public class NewController {
    @Autowired
    NewService newService;

    @Autowired
    RoleService roleService;
    
    @PostMapping
    public New create(@RequestBody NewDTO dto) {
        return newService.create(roleService.getId(), dto);
    }
    
}
