package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.dto.CorpRegister.CorpRegisterDTO;
import team.symmetry.ResumeBack.exceptions.NotFound;
import team.symmetry.ResumeBack.models.CorpRegister;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.CorpRegisterRepo;
import team.symmetry.ResumeBack.repos.UserRepository;
import team.symmetry.ResumeBack.utils.EntityValidator;
import team.symmetry.ResumeBack.utils.MailHelp;

@Service
public class CorpRegisterService {
    @Autowired
    CorpRegisterRepo corpRegisterRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityValidator validator;

    @Autowired
    MailHelp mailHelp;

    public CorpRegister create(User user, CorpRegisterDTO dto) {
        validator.validate(dto);

        CorpRegister corpRegister = corpRegisterRepo.save(CorpRegister.builder()
                .name(dto.getName())
                .urName(dto.getUrName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .user(user)
                .build());

        //mailHelp.sendReqMail(dto); TODO: проверка отправки по почте

        return corpRegister;
    }

    public CorpRegister getById(int id) {
        return corpRegisterRepo.findById(id).orElseThrow(NotFound::new);
    }

    public void delete(int id) {
        corpRegisterRepo.deleteById(id);
    }
}
