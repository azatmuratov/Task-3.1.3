package ru.itmentor.spring_boot.restTemplate.repositories;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmentor.spring_boot.restTemplate.model.Role;
import ru.itmentor.spring_boot.restTemplate.model.User;
import ru.itmentor.spring_boot.restTemplate.services.RoleService;
import ru.itmentor.spring_boot.restTemplate.services.UserService;


@Component
public class InitializingBeanImpl implements InitializingBean {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public InitializingBeanImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Role roleAdmin = new Role(1, "ROLE_ADMIN");
        roleService.add(roleAdmin);
        User user6 = new User("admin", "admin", "Admin", "Admin", "6000000006", roleAdmin);
        userService.add(user6);
    }
}
