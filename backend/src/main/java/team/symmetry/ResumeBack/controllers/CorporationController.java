package team.symmetry.ResumeBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.CorpRegister.CorpRegisterDTO;
import team.symmetry.ResumeBack.models.CorpRegister;
import team.symmetry.ResumeBack.models.Corporation;
import team.symmetry.ResumeBack.services.CorpRegisterService;
import team.symmetry.ResumeBack.services.CorporationService;
import team.symmetry.ResumeBack.services.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/corporation")
@CrossOrigin
public class CorporationController {
    @Autowired
    CorporationService corporationService;

    @Autowired
    CorpRegisterService corpRegisterService;

    @Autowired
    RoleService roleService;

    @PostMapping("/request")
    public CorpRegister request(@RequestBody CorpRegisterDTO dto) {
        return corpRegisterService.create(roleService.getId(), dto);
    }

    @PostMapping("/register/{id}")
    public Corporation create(@PathVariable("id") Integer id) {
        return corporationService.register(id);
    }
}
