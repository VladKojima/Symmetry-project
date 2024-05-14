package team.symmetry.ResumeBack.dto.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;
import team.symmetry.ResumeBack.models.Department;

@Data
@ToString
public class RegisterInfo {
    private Integer number;
    private String photoPath;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;
    @NotNull
    @Pattern(regexp = "^\\d{8}$")
    private String birthday;
    @NotNull
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;

    @Email
    private String email;
    private String telegram;
    private String aboutSelf;
    private String healthFeatures;
    private Department department;
}
