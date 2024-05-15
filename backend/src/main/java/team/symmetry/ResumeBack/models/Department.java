package team.symmetry.ResumeBack.models;

import java.util.Set;

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
import lombok.Builder;
import lombok.Value;

@Entity
@Table(name = "departments")
@Value
@Builder
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "facultyid", nullable = false)
    @JsonIgnore
    private Faculty faculty;

    @OneToMany(mappedBy = "learningPlace")
    @JsonIgnore
    Set<Student> students;

    @OneToMany(mappedBy = "workingPlace")
    @JsonIgnore
    Set<Moderator> moderators;
}
