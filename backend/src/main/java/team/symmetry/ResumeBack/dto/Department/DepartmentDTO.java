package team.symmetry.ResumeBack.dto.Department;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.Faculty;

@Data
public class DepartmentDTO {
    @NotNull
    private String name;
    @NotNull
    private Faculty faculty;
}
