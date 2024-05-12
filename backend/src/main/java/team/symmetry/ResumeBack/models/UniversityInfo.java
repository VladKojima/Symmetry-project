package team.symmetry.ResumeBack.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class UniversityInfo {
    @OneToMany(mappedBy = "student")
    List<Competition> competitions;
    
    @OneToMany(mappedBy = "student")
    List<Grant> grants;

    @OneToMany(mappedBy = "student")
    List<Publication> publications;

    @OneToMany(mappedBy = "student")
    List<SomeActivity> someActivities;

    @OneToMany(mappedBy = "student")
    List<StudentStatus> statuses;

    @OneToMany(mappedBy = "student")
    List<TrainingCertificate> certificates;

    @OneToMany(mappedBy = "student")
    List<Interest> interests;

    @NotNull
    @Column(nullable = false, table = "students")
    String groupTitle;
}
