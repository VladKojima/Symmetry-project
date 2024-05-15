package team.symmetry.ResumeBack.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.service.dto.authorization.Roles;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.dto.Student.Profile;
import team.symmetry.ResumeBack.dto.Student.QuickProfile;
import team.symmetry.ResumeBack.dto.Student.RegisterInfo;
import team.symmetry.ResumeBack.exceptions.NotFound;
import team.symmetry.ResumeBack.exceptions.WrongDateException;
import team.symmetry.ResumeBack.models.OtherInfo;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.models.UniversityInfo;
import team.symmetry.ResumeBack.models.User;
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
        Student student = studentRepo.findById(id).orElseThrow(NotFound::new);

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
                .skills(student.getSkills())
                .tags(student.getTags())
                .interests(student.getUniversityInfo().getInterests())
                .aboutSelf(student.getOtherInfo().getAboutSelf())
                .healthFeatures(student.getHealthFeatures())
                .experiences(student.getOtherInfo().getWorkExperience())
                .build();

    }

    @Transactional
    public void updateProfile(User user, Profile profile) {
        validator.validate(profile);

        if (user.getRole() == Roles.STUDENT) {
            profile.setId(user.getAccId());
        }

        Student student = studentRepo.findById(profile.getId()).orElseThrow();

        OtherInfo oInfo = student.getOtherInfo();
        UniversityInfo uInfo = student.getUniversityInfo();

        oInfo.setAboutSelf(profile.getAboutSelf());
        oInfo.setWorkExperience(profile.getExperiences());

        uInfo.setInterests(profile.getInterests());

        student.setPhotoPath(profile.getPhotoPath());
        student.setName(profile.getName());
        student.setSurname(profile.getSurname());
        student.setPatronymic(profile.getPatronymic());
        student.setBirthday(profile.getBirthday());
        student.setPhone(profile.getPhone());
        student.setEmail(profile.getEmail());
        student.setTelegram(profile.getTelegram());
        student.setHealthFeatures(profile.getHealthFeatures());
        student.setSkills(profile.getSkills());
        student.setTags(profile.getTags());

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
                            .name(info.getName())
                            .surname(info.getSurname())
                            .patronymic(info.getPatronymic())
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

    public List<QuickProfile> getAll() {
        return studentRepo.findAll().stream()
                .map(student -> QuickProfile.builder()
                        .name(student.getName())
                        .surname(student.getSurname())
                        .patronymic(student.getPatronymic())
                        .tags(student.getTags())
                        .photoPath(student.getPhotoPath())
                        .hasExp(!student.getOtherInfo().getWorkExperience().isEmpty())
                        .build())
                .toList();
    }
}
