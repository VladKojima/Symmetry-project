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

@Entity
@Table(name = "ew_exps")
@Data
@AllArgsConstructor
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String place;

    private String details;

    @NotNull
    @Column(nullable = false)
    private String position;

    @NotNull
    @Column(nullable = false)
    private Date startDate;

    @NotNull
    @Column(nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    @JsonIgnore
    Student student;
}
