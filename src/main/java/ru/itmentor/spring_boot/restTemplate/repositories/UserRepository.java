package ru.itmentor.spring_boot.restTemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring_boot.restTemplate.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByLogin(String login);
}
