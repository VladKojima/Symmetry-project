package team.symmetry.ResumeBack.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import team.symmetry.ResumeBack.models.enums.Languages;
import team.symmetry.ResumeBack.models.enums.TypeOfLearn;

@Embeddable
@Data
public class OtherInfo {
    @OneToMany(mappedBy = "student")
    private List<WorkExperience> workExperience;

    @Column(nullable = true, table = "students")
    private String hobbies;

    @Column(nullable = true, table = "students")
    private String aboutSelf;

    @Column(nullable = true, table = "students")
    private String notWorkExp;

    @NotNull
    @Column(nullable = false, table = "students")
    private List<Languages> languages;

    @Column(nullable = true, table = "students")
    private Integer wantWages;

    @NotNull
    @Max(5)
    @Column(nullable = false, table = "students")
    private Integer year;

    @NotNull
    @Column(nullable = false, table = "students")
    private TypeOfLearn typeOfLearn;
}
