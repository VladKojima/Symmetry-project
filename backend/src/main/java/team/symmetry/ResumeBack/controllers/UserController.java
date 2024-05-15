package team.symmetry.ResumeBack.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import team.symmetry.ResumeBack.dto.NewPasswordDTO;
import team.symmetry.ResumeBack.services.RoleService;
import team.symmetry.ResumeBack.services.UserService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PutMapping("password")
    public void changePassword(@RequestBody NewPasswordDTO dto) {
        userService.changePassword(roleService.getUser(), dto);
    }
}
