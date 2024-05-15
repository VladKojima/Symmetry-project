package team.symmetry.ResumeBack.dto.New;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.Tag;

@Data
public class NewDTO {
    @NotNull
    private String header;
    @NotNull
    private String textBody;
    @NotNull
    private List<Tag> tags;
}
