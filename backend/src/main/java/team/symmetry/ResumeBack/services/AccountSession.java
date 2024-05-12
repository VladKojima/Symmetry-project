package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.UserRepository;

import java.security.Principal;
import java.util.Optional;


@Component
public class AccountSession {

    @Autowired
    private UserRepository userRepository;

    public User getUserSession(){
        return Optional.of(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Principal::getName)
                .map(userRepository::findByLogin)
                .flatMap(user -> user)
                .orElse(null);
    }

}
