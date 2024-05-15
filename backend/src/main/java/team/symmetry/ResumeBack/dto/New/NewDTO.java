package team.symmetry.ResumeBack.dto.New;

import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.Tag;

@Data
public class NewDTO {
    @NotNull
    private String header;
    @NotNull
    private String textBody;

    private Set<Tag> tags;
}
