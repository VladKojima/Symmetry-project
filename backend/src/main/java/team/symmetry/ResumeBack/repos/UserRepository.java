package team.symmetry.ResumeBack.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.symmetry.ResumeBack.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    Optional<User> findByLogin(String login);
    Optional<User> findById(Integer id);
}
