package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.Student.Profile;
import team.symmetry.ResumeBack.dto.Student.RegisterInfo;
import team.symmetry.ResumeBack.models.OtherInfo;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.repos.StudentRepo;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class StudentService {
    @Autowired
    EntityValidator validator;

    @Autowired
    StudentRepo studentRepo;

    public Profile getProfile(int id) {
        Student student = studentRepo.findById(id).orElseThrow();

        return Profile.builder()
                .id(student.getId())
                .photo(student.getPhotoPath())
                .name(student.getName())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .birthday(student.getBirthday())
                .phone(student.getPhone())
                .email(student.getEmail())
                .telegram(student.getTelegram())
                .skills(student.getSkills())
                .tags(student.getTags())
                .interests(student.getUniversityInfo().getInterests())
                .aboutSelf(student.getOtherInfo().getAboutSelf())
                .healthFeatures(student.getHealthFeatures())
                .build();

    }

    public void updateProfile(Profile profile) {
        validator.validate(profile);

        Student student = studentRepo.findById(profile.getId()).orElseThrow();

        OtherInfo oInfo = student.getOtherInfo();

        oInfo.setAboutSelf(profile.getAboutSelf());

        student.setPhotoPath(profile.getPhoto());
        student.setName(profile.getName());
        student.setSurname(profile.getSurname());
        student.setPatronymic(profile.getPatronymic());
        student.setBirthday(profile.getBirthday());
        student.setPhone(profile.getPhone());
        student.setEmail(profile.getEmail());
        student.setTelegram(profile.getTelegram());
        student.setHealthFeatures(profile.getHealthFeatures());

        studentRepo.save(student);
    }

    public Student create(RegisterInfo info) {
        validator.validate(info);

        return studentRepo.save(
                Student.builder()
                        .photoPath(info.getPhoto())
                        .name(info.getName())
                        .surname(info.getSurname())
                        .patronymic(info.getPatronymic())
                        .phone(info.getPhone())
                        .email(info.getEmail())
                        .telegram(info.getTelegram())
                        .birthday(info.getBirthday())
                        .isActive(true)
                        .block(false)
                        .build());
    }
}
