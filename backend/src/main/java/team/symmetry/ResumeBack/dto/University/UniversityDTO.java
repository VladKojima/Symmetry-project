package team.symmetry.ResumeBack.dto.University;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UniversityDTO {
    @NotNull
    private String name;
}
