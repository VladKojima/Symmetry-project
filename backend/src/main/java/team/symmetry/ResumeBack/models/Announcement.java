package team.symmetry.ResumeBack.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "announcements")
@Data
@Builder
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
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "corporationid", nullable = false)
    private Corporation corporation;

    @ManyToMany(mappedBy = "responsedAnnouncements")
    private Set<Student> students;
}
