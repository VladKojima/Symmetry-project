package team.symmetry.ResumeBack.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "departments")
@Value
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "facultyid", nullable = false)
    @JsonIgnore
    private Faculty faculty;

    @OneToMany(mappedBy = "learningPlace")
    @JsonIgnore
    List<Student> students;

    @OneToMany(mappedBy = "workingPlace")
    @JsonIgnore
    List<Moderator> moderators;
}
