package team.symmetry.ResumeBack.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewPasswordDTO {
    @NotNull
    private String newPassword;
}
