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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "corporations")
@Data
@AllArgsConstructor
public class Corporation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String photoPath;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String urName;

    @NotNull
    @Column(nullable = false)
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;

    @NotNull
    @Column(nullable = false)
    @Email
    private String email;

    @ManyToMany
    @JoinTable(
        name = "corporation_to_tag",
        joinColumns = @JoinColumn(name = "corporationid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "tagid", nullable = false)
    )
    private List<Tag> tags;

    private String about;

    private String url;

    @OneToMany(mappedBy = "corporation")
    @JsonIgnore
    private List<Announcement> announcements;
}
