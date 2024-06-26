package team.symmetry.ResumeBack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String lastname;
    private String surname;
    private String login;
    private String password;
    private String role;
    private Integer accId;
}
