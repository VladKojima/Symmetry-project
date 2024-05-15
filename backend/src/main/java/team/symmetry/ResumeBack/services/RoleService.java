package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jwt.service.dto.JwtAuthentication;
import com.jwt.service.dto.authorization.Roles;

import team.symmetry.ResumeBack.models.User;
import team.symmetry.ResumeBack.repos.UserRepository;

@Service
public class RoleService {

    @Autowired
    UserRepository userRepository;
    
    public boolean hasRole(Roles role){
       JwtAuthentication auth = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();

       return auth.getRole() == role;
    }

    public boolean hasSameId(int id){
        JwtAuthentication auth = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByLogin(auth.getLogin()).orElseThrow();
        
        return user.getAccId() == id;
    }

    public int getId(){
        JwtAuthentication auth = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByLogin(auth.getLogin()).orElseThrow();
        
        return user.getAccId();
    }

    public User getUser(){
        JwtAuthentication auth = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByLogin(auth.getLogin()).orElseThrow();
        
        return user;
    }
}
