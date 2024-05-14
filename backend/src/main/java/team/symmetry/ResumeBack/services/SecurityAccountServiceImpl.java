package team.symmetry.ResumeBack.services;

import com.jwt.service.dto.authorization.Account;
import com.jwt.service.service.SecurityAccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SecurityAccountServiceImpl implements SecurityAccountService {
    private final UserRepository userRepository;

    @Override
    public Optional<Account> findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElse(null);

        if (user == null) {
            return Optional.empty();
        }

        Account account = new Account();
        account.setLogin(user.getLogin());
        account.setPassword(user.getPassword());
        account.setRole(user.getRole());

        return Optional.of(account);
    }
}
