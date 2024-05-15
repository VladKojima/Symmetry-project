package team.symmetry.ResumeBack.dto.Moderator;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ModeratorDTO {
    private String login;
    private String password;

    private String name;
    private String surname;
    
    @NotNull
    @Column(nullable = false)
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;

    @NotNull
    @Column(nullable = false)
    @Email
    private String email;
}
