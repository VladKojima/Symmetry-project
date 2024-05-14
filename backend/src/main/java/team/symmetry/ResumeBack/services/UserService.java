package team.symmetry.ResumeBack.services;

import java.util.List;
import java.util.function.Consumer;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.exceptions.UserNotFoundException;
import team.symmetry.ResumeBack.models.Corporation;
import team.symmetry.ResumeBack.models.Moderator;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.models.User;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(Integer id) throws UserNotFoundException;

    UserDto findByName(String name) throws UserNotFoundException;
    UserDto createUser(UserDto userDto);
    void deleteUserById(Integer id) throws UserNotFoundException;
    UserDto updateUser(Integer id, UserDto userDTO);
    UserDto getUserSession();

    UserDto toDTO(User user);

    User toUser(UserDto userDto);

    public void onRole(User user, Consumer<Moderator> onModerator, Consumer<Student> onStudent, Consumer<Corporation> onCorporation);
}