package team.symmetry.ResumeBack.dto.Student;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterInfo {
    private Integer number;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;
    @NotNull
    @Pattern(regexp = "^\\d{8}$")
    private String birthday;
}
