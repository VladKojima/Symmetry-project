package team.symmetry.ResumeBack.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
