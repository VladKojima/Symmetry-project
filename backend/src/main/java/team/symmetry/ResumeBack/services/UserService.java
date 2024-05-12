package team.symmetry.ResumeBack.services;

import java.util.List;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.exceptions.UserNotFoundException;
import team.symmetry.ResumeBack.models.User;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(Integer id) throws UserNotFoundException;

    UserDto findByName(String name) throws UserNotFoundException;
    UserDto createUser(UserDto userDto);
    void deleteUserById(Integer id) throws UserNotFoundException;
    UserDto updateUser(Integer id, UserDto userDTO);
    UserDto getUserSession();

    String singIn(String login, String password);
    void signOut(String login);
    Integer getInto(String login);
    UserDto toDTO(User user);

    User toUser(UserDto userDto);
}