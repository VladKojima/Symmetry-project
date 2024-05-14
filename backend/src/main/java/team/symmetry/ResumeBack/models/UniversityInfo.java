package team.symmetry.ResumeBack.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class UniversityInfo {
    @OneToMany(mappedBy = "student")
    Set<Competition> competitions;
    
    @OneToMany(mappedBy = "student")
    Set<Grant> grants;

    @OneToMany(mappedBy = "student")
    Set<Publication> publications;

    @OneToMany(mappedBy = "student")
    Set<SomeActivity> someActivities;

    @OneToMany(mappedBy = "student")
    Set<StudentStatus> statuses;

    @OneToMany(mappedBy = "student")
    Set<TrainingCertificate> certificates;

    @OneToMany(mappedBy = "student")
    Set<Interest> interests;

    @NotNull
    @Column(nullable = true, table = "students")
    String groupTitle;
}
