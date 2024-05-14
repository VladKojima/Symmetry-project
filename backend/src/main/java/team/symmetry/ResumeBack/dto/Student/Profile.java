package team.symmetry.ResumeBack.dto.Student;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import team.symmetry.ResumeBack.models.Interest;
import team.symmetry.ResumeBack.models.Skill;
import team.symmetry.ResumeBack.models.Tag;

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
    private List<Skill> skills;
    private List<Tag> tags;
    private List<Interest> interests;
    private String aboutSelf;
    private String healthFeatures;
}
