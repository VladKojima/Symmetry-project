package team.symmetry.ResumeBack.models;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role = "user";
    @Column(name = "flag")
    private Integer flag = 0;


    public User(String name, String lastname, String surname, String login, String password, String role, Integer flag) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.flag = flag;
        this.role = role;
    }
}
