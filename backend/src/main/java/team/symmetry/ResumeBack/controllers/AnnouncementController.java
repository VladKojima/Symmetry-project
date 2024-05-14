package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Announcement.AnnouncementDTO;
import team.symmetry.ResumeBack.models.Announcement;
import team.symmetry.ResumeBack.services.AnnouncementService;
import team.symmetry.ResumeBack.services.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/announcement")
@CrossOrigin
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Announcement> getAll(){
        return announcementService.getAll();
    }

    @PostMapping
    public Announcement create(@RequestBody AnnouncementDTO entity) {
        return announcementService.create(roleService.getId(), entity);
    }

    @PostMapping("/response/{id}")
    public void response(@PathVariable("id") Integer id) {
        announcementService.response(roleService.getId(), id);
    }

}
