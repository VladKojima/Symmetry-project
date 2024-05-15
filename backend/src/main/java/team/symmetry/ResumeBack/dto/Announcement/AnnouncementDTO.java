package team.symmetry.ResumeBack.dto.Announcement;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.Tag;

@Data
public class AnnouncementDTO {
    @NotNull
    private String header;
    @NotNull
    private String textBody;

    private String needs;

    private String conditionsProvided;

    private List<Tag> tags;
}
