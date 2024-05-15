package team.symmetry.ResumeBack.dto.Announcement;

import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnnouncementDTO {
    @NotNull
    private String header;
    @NotNull
    private String textBody;

    private String needs;

    private String conditionsProvided;

    private Set<String> tags;
}
