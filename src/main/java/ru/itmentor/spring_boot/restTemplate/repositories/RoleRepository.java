package ru.itmentor.spring_boot.restTemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring_boot.restTemplate.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);
}
