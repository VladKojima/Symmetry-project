package team.symmetry.ResumeBack.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "moderators")
@Data
@AllArgsConstructor
public class Moderator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String photoPath;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String surname;

    private String patronymic;
    
    @NotNull
    @Column(nullable = false)
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;

    @NotNull
    @Column(nullable = false)
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "departmentid", nullable = false)
    private Department workingPlace;

    @ManyToMany
    @JoinTable(
        name = "moderator_to_announcement",
        joinColumns = @JoinColumn(name = "moderatorid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "announcementid", nullable = false)
    )
    @JsonIgnore
    private List<Announcement> announcements;
}
