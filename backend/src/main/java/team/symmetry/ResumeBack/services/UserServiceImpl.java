package team.symmetry.ResumeBack.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.exceptions.UserNotFoundException;
import team.symmetry.ResumeBack.models.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private team.symmetry.ResumeBack.repos.UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountSession accountSession;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public UserDto getUserById(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return toDTO(user.get());
    }

    @Override
    public UserDto findByName(String name) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByName(name));

        if (user.isEmpty()) {
            throw new UserNotFoundException("нету такого пользователя");
        }
        return toDTO(user.get());
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        userRepository.save(toUser(userDto));
        return userDto;
    }

    @Override
    public void deleteUserById(Integer id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("нету такого пользователя");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDTO) {
        UserDto userDB = getUserById(id);
        if (Objects.nonNull(userDTO.getName()) && !"".equalsIgnoreCase(userDTO.getName())) {
            userDB.setName(userDTO.getName());
        }

        userRepository.save(toUser(userDB));
        return userDB;
    }

    @Override
    public UserDto getUserSession() {
        return Optional.ofNullable(accountSession.getUserSession())
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public String singIn(String login, String password) {
        User user = userRepository.findByLogin(login).orElse(null);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        user.setFlag(1);
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        userRepository.save(user);
        return login;
    }

    @Override
    public void signOut(String login) {
        User user = userRepository.findByLogin(login).orElse(null);
        if (user != null) {
            user.setFlag(0);
            userRepository.save(user);
        }
    }

    @Override
    public Integer getInto(String login) {
        User user = userRepository.findByLogin(login).orElse(null);
        if (user != null) {
            return user.getFlag();
        }
        return null;
    }

    @Override
    public UserDto toDTO(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .surname(user.getSurname())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .flag(user.getFlag())
                .build();
    }

    @Override
    public User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .surname(userDto.getSurname())
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole())
                .flag(userDto.getFlag())
                .build();
    }
}
