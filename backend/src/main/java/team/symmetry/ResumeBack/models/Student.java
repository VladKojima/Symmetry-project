package team.symmetry.ResumeBack.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "students")
@Data
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    private String telegram;

    @NotNull
    @Column(nullable = false)
    private Date birthday;

    @ManyToMany
    @JoinTable(
        name = "student_to_tag",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "tagid", nullable = false)
    )
    private List<Tag> tags;

    @ManyToMany
    @JoinTable(
        name = "student_to_skill",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "skillid", nullable = false)
    )
    private List<Skill> skills;

    @NotNull
    @Column(nullable = false)
    private Boolean isActive;

    @Embedded
    private UniversityInfo sstuInfo;

    @Embedded
    private OtherInfo otherInfo;

    @ManyToOne
    @JoinColumn(name = "departmentid", nullable = false)
    private Department learningPlace;

    @NotNull
    @Column(nullable = false)
    private String healthFeatures;

    @NotNull
    @Column(nullable = false)
    private Boolean block;

    @ManyToMany
    @JoinTable(
        name = "job_response",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "announcementid", nullable = false)
    )
    @JsonIgnore
    private List<Announcement> responsedAnnouncements;
}
