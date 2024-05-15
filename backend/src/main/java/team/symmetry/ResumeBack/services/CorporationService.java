package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.symmetry.ResumeBack.models.CorpRegister;
import team.symmetry.ResumeBack.models.Corporation;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.CorporationRepo;
import team.symmetry.ResumeBack.repos.UserRepository;
import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class CorporationService {
    @Autowired
    CorporationRepo corporationRepo;

    @Autowired
    CorpRegisterService corpRegisterService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityValidator validator;

    @Transactional
    public Corporation register(int reqId) {
        CorpRegister newCorp = corpRegisterService.getById(reqId);

        corpRegisterService.delete(reqId);

        Corporation corporation = corporationRepo.save(Corporation.builder()
                .name(newCorp.getName())
                .urName(newCorp.getUrName())
                .phone(newCorp.getPhone())
                .email(newCorp.getEmail())
                .build());

        User user = newCorp.getUser();

        user.setAccId(corporation.getId());

        userRepository.save(user);

        return corporation;
    }
}
