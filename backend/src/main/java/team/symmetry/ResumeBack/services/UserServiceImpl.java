package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.service.dto.authorization.Roles;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.exceptions.UserNotFoundException;
import team.symmetry.ResumeBack.models.Corporation;
import team.symmetry.ResumeBack.models.Moderator;
import team.symmetry.ResumeBack.models.Student;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.CorporationRepo;
import team.symmetry.ResumeBack.repos.ModeratorRepo;
import team.symmetry.ResumeBack.repos.StudentRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private team.symmetry.ResumeBack.repos.UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountSession accountSession;

    @Autowired
    private ModeratorRepo moderatorRepo;
    @Autowired
    private CorporationRepo corporationRepo;
    @Autowired
    private StudentRepo studentRepo;

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
    public UserDto toDTO(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .build();
    }

    @Override
    public User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(Roles.valueOf(userDto.getRole()))
                .build();
    }

    public void onRole(User user, Consumer<Moderator> onModerator, Consumer<Student> onStudent,
            Consumer<Corporation> onCorporation) {

        switch (user.getRole()) {
            case MODERATOR:
                onModerator.accept(moderatorRepo.findById(user.getAccId()).orElseThrow());
                break;
            case STUDENT:
                onStudent.accept(studentRepo.findById(user.getAccId()).orElseThrow());
                break;
            case CORPORATION:
                onCorporation.accept(corporationRepo.findById(user.getAccId()).orElseThrow());
                break;
            default:
                break;
        }
    }
}
