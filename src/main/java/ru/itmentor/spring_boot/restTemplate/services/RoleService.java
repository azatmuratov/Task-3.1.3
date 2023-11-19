package ru.itmentor.spring_boot.restTemplate.services;





import ru.itmentor.spring_boot.restTemplate.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);
    List<Role> listRoles();
}
