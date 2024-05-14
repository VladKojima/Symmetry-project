package team.symmetry.ResumeBack.dto.Student;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
import team.symmetry.ResumeBack.models.Tag;

@Data
@Builder
public class QuickProfile {
    private String name;
    private String surname;
    private String patronymic;
    private Set<Tag> tags;
    private String photoPath;
    private Boolean hasExp;
}
