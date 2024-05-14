package team.symmetry.ResumeBack.models;

import java.util.Date;
import java.util.Set;

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
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String photoPath;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private String patronymic;
    
    @Column(nullable = false)
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phone;

    @Column(nullable = false)
    @Email
    private String email;

    private String telegram;

    @Column(nullable = true)
    private Date birthday;

    @ManyToMany
    @JoinTable(
        name = "student_to_tag",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "tagid", nullable = false)
    )
    private Set<Tag> tags;

    @ManyToMany
    @JoinTable(
        name = "student_to_skill",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "skillid", nullable = false)
    )
    private Set<Skill> skills;

    @Column(nullable = false)
    private Boolean isActive;

    @Embedded
    private UniversityInfo universityInfo;

    @Embedded
    private OtherInfo otherInfo;

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department learningPlace;

    @Column(nullable = true)
    private String healthFeatures;

    @Column(nullable = false)
    private Boolean block;

    @ManyToMany
    @JoinTable(
        name = "job_response",
        joinColumns = @JoinColumn(name = "studentid", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "announcementid", nullable = false)
    )
    @JsonIgnore
    private Set<Announcement> responsedAnnouncements;
}
