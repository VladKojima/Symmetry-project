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
import team.symmetry.ResumeBack.models.enums.Status;
import team.symmetry.ResumeBack.models.enums.TypeComp;
import team.symmetry.ResumeBack.models.enums.Victory;

@Entity
@Table(name = "competitions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Status status;

    @NotNull
    @Column(nullable = false)
    private TypeComp typeComp;

    @NotNull
    @Column(nullable = false)
    private Victory victory;

    @NotNull
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    @JsonIgnore
    Student student;
}
