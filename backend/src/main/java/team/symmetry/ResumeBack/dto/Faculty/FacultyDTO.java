package team.symmetry.ResumeBack.dto.Faculty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.University;

@Data
public class FacultyDTO {
    @NotNull
    private String name;
    @NotNull
    private University university;
}
