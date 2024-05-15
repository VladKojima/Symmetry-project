package team.symmetry.ResumeBack.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.symmetry.ResumeBack.models.enums.TypeStatus;

@Entity
@Table(name = "student_statuses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Date date;

    @NotNull
    @Column(nullable = false)
    private TypeStatus type;

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    @JsonIgnore
    Student student;
}
