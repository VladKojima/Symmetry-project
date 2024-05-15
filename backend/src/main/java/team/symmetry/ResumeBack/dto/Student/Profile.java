package team.symmetry.ResumeBack.dto.Student;

import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import team.symmetry.ResumeBack.models.Interest;
import team.symmetry.ResumeBack.models.Skill;
import team.symmetry.ResumeBack.models.Tag;
import team.symmetry.ResumeBack.models.WorkExperience;

@Data
@Builder
public class Profile {
    private Integer id;

    private String photoPath;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;
    @NotNull
    private Date birthday;
    @NotNull
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;
    @NotNull
    @Email
    private String email;
    private String telegram;
    private Set<Skill> skills;
    private Set<Tag> tags;
    private Set<Interest> interests;
    private Set<WorkExperience> experiences;
    private String aboutSelf;
    private String healthFeatures;
}
