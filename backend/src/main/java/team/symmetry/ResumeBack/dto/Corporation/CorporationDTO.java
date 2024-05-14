package team.symmetry.ResumeBack.dto.Corporation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CorporationDTO {
    private String photoPath;
    @NotNull
    private String name;
    @NotNull
    private String urName;
    @NotNull
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;
    @NotNull
    @Email
    private String email;

    private String about;

    private String url;
}
