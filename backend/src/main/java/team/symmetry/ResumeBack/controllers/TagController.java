package team.symmetry.ResumeBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.symmetry.ResumeBack.dto.Tag.TagDTO;
import team.symmetry.ResumeBack.models.Tag;
import team.symmetry.ResumeBack.services.TagService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/tag")
@CrossOrigin
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAll();
    }
    

    @PostMapping
    public Tag create(@RequestBody TagDTO entity) {
        
        
        return tagService.create(entity);
    }
    
}
