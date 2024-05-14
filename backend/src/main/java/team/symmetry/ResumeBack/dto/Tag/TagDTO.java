package team.symmetry.ResumeBack.dto.Tag;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TagDTO {
    @NotNull
    private String name;
}
