package team.symmetry.ResumeBack.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "tags")
@Value
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Student> students;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Announcement> announcements;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Corporation> corporations;
}
