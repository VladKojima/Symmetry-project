package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Moderator.ModeratorDTO;
import team.symmetry.ResumeBack.models.Moderator;
import team.symmetry.ResumeBack.services.ModeratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/moderator")
@CrossOrigin
public class ModeratorController {

    @Autowired
    ModeratorService moderatorService;

    @GetMapping
    public List<Moderator> getAll() {
        return moderatorService.getAll();
    }

    @PostMapping
    public Moderator create(@RequestBody ModeratorDTO dto) {

        return moderatorService.create(dto);
    }

}
