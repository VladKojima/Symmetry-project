package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.New.NewDTO;
import team.symmetry.ResumeBack.models.New;
import team.symmetry.ResumeBack.repos.ModeratorRepo;
import team.symmetry.ResumeBack.repos.NewRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class NewService {
    @Autowired
    NewRepo newRepo;

    @Autowired
    ModeratorRepo moderatorRepo;

    @Autowired
    EntityValidator validator;

    public New create(int moderId, NewDTO dto) {
        validator.validate(dto);

        return newRepo.save(
                New.builder()
                        .header(dto.getHeader())
                        .textBody(dto.getTextBody())
                        .tags(dto.getTags())
                        .moderator(moderatorRepo.findById(moderId).orElseThrow())
                        .build());
    }
}