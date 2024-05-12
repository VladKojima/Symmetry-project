package team.symmetry.ResumeBack.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "announcements")
@Data
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String header;

    @NotNull
    @Column(nullable = false)
    private String textBody;

    private String needs;

    private String conditionsProvided;

    @ManyToMany
    @JoinTable(
        name = "announcement_to_tag",
        joinColumns = @JoinColumn(name = "announcementid", nullable = false),
        inverseJoinColumns= @JoinColumn(name = "tagid", nullable = false)
    )
    private List<Tag> tags;

    @ManyToMany(mappedBy = "announcements")
    private List<Corporation> corporations;

    @ManyToMany(mappedBy = "announcements")
    private List<Moderator> moderators;
}
