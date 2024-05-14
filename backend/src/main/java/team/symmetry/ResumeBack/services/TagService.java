package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Tag.TagDTO;
import team.symmetry.ResumeBack.models.Tag;
import team.symmetry.ResumeBack.repos.TagRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class TagService {
    @Autowired
    EntityValidator validator;

    @Autowired
    TagRepo tagRepo;

    public List<Tag> getAll(){
        return tagRepo.findAll();
    }

    public Tag create(TagDTO dto) {
        validator.validate(dto);

        return tagRepo.save(new Tag(null, dto.getName(), null, null, null, null));
    }
}
