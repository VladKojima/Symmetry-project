package team.symmetry.ResumeBack.dto.Student;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import team.symmetry.ResumeBack.models.Department;

@Data
public class RegisterInfo {
    private String photo;
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
    private String aboutSelf;
    private String healthFeatures;
    // private Department department;
}
