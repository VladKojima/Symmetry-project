package team.symmetry.ResumeBack.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Announcement.AnnouncementDTO;
import team.symmetry.ResumeBack.models.Announcement;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.models.Tag;
import team.symmetry.ResumeBack.repos.AnnouncementRepo;
import team.symmetry.ResumeBack.repos.CorporationRepo;
import team.symmetry.ResumeBack.repos.StudentRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepo announcementRepo;

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CorporationRepo corporationRepo;

    @Autowired
    EntityValidator validator;

    @Autowired
    TagService tagService;

    public Announcement create(int corporationId, AnnouncementDTO dto) {
        validator.validate(dto);

        List<Tag> tags = tagService.getAll();

        List<Tag> has = tags.stream().filter(tag -> dto.getTags().contains(tag.getName())).toList();

        List<String> needed = dto.getTags().stream()
                .filter(tag -> !tags.stream().map(t -> t.getName()).toList().contains(tag)).toList();

        has.addAll(tagService.createAll(needed));

        return announcementRepo.save(Announcement.builder()
                .header(dto.getHeader())
                .textBody(dto.getTextBody())
                .needs(dto.getNeeds())
                .conditionsProvided(dto.getConditionsProvided())
                .tags(has.stream().collect(Collectors.toSet()))
                .corporation(corporationRepo.findById(corporationId).orElseThrow())
                .build());
    }

    public void response(int studentId, int id) {
        Announcement ann = announcementRepo.findById(id).orElseThrow();

        Student student = studentRepo.findById(studentId).orElseThrow();

        ann.getStudents().add(student);

        announcementRepo.save(ann);
    }

    public List<Announcement> getAll() {
        return announcementRepo.findAll();
    }
}
