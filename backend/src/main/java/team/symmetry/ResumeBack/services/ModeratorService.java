package team.symmetry.ResumeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.service.dto.authorization.Roles;

import team.symmetry.ResumeBack.dto.Moderator.ModeratorDTO;
import team.symmetry.ResumeBack.models.Moderator;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.ModeratorRepo;
import team.symmetry.ResumeBack.repos.UserRepository;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class ModeratorService {
    @Autowired
    ModeratorRepo moderatorRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityValidator validator;

    public List<Moderator> getAll(){
        return moderatorRepo.findAll();
    }

    @Transactional
    public Moderator create(ModeratorDTO dto) {
        validator.validate(dto);

        Moderator moderator = moderatorRepo.save(Moderator.builder()
            .name(dto.getName())
            .surname(dto.getSurname())
            .phone(dto.getPhone())
            .email(dto.getEmail())
            .build()
        );

        userRepository.save(
            User.builder()
                .login(dto.getLogin())
                .password(dto.getPassword())
                .role(Roles.MODERATOR)
                .build()   
        );

        return moderator;
    }
}
