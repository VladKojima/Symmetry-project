package team.symmetry.ResumeBack.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.dto.Student.Profile;
import team.symmetry.ResumeBack.dto.Student.RegisterInfo;
import team.symmetry.ResumeBack.exceptions.WrongDateException;
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

    @Autowired
    UserService userService;

    public Profile getProfile(int id) {
        Student student = studentRepo.findById(id).orElseThrow();

        return Profile.builder()
                .id(student.getId())
                .photoPath(student.getPhotoPath())
                .name(student.getName())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .birthday(student.getBirthday())
                .phone(student.getPhone())
                .email(student.getEmail())
                .telegram(student.getTelegram())
                .skills(student.getSkills().stream().toList())
                .tags(student.getTags().stream().toList())
                .interests(student.getUniversityInfo().getInterests().stream().toList())
                .aboutSelf(student.getOtherInfo().getAboutSelf())
                .healthFeatures(student.getHealthFeatures())
                .build();

    }

    @Transactional
    public void updateProfile(Profile profile) {
        validator.validate(profile);

        Student student = studentRepo.findById(profile.getId()).orElseThrow();

        OtherInfo oInfo = student.getOtherInfo();

        oInfo.setAboutSelf(profile.getAboutSelf());

        student.setPhotoPath(profile.getPhotoPath());
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

    @Transactional
    public Student create(RegisterInfo info) {
        validator.validate(info);

        SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy");

        try {
            Date birthday = formater.parse(info.getBirthday());

            Student student = studentRepo.save(
                    Student.builder()
                            .photoPath(info.getPhotoPath())
                            .name(info.getName())
                            .surname(info.getSurname())
                            .patronymic(info.getPatronymic())
                            .phone(info.getPhone())
                            .email(info.getEmail())
                            .telegram(info.getTelegram())
                            .birthday(birthday)
                            .isActive(true)
                            .block(false)
                            .build());

            userService.createUser(UserDto.builder()
                    .login(info.getNumber().toString())
                    .name(info.getName())
                    .surname(info.getSurname())
                    .lastname(info.getPatronymic())
                    .role("STUDENT")
                    .password(info.getBirthday())
                    .accId(student.getId())
                    .build());

            return student;

        }

        catch (ParseException e) {
            throw new WrongDateException();
        }

    }
}
