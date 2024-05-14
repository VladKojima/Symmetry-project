package team.symmetry.ResumeBack.dto.Skill;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillDTO {
    @NotNull
    private String name;
}
