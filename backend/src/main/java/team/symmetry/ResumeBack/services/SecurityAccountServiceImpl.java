package team.symmetry.ResumeBack.services;

import com.jwt.service.dto.authorization.Account;
import com.jwt.service.service.SecurityAccountService;
import lombok.RequiredArgsConstructor;
import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.UserRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
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
        Optional.ofNullable(user.getRole())
                        .map(Set::of)
                                .ifPresentOrElse(account::setRoles,
                                        () -> account.setRoles(Set.of("USER")));

        return Optional.of(account);
    }
}
