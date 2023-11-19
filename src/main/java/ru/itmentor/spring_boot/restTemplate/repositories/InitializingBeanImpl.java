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
        Role roleUser = new Role(2, "ROLE_USER");
        roleService.add(roleAdmin);
        roleService.add(roleUser);

        User user1 = new User("usr1", "1", "Vasa", "Ivanov", "1000000001", roleUser);
        User user2 = new User("usr2", "2", "Petya", "Golovach", "2000000002", roleUser);
        User user3 = new User("usr3", "3", "Bob", "Sponge", "3000000003", roleUser);
        User user4 = new User("usr4", "4", "Johan", "Kek", "4000000004", roleUser);
        User user5 = new User("usr5", "5", "Pepa", "Josefina", "5000000005", roleUser);
        User user6 = new User("admin", "admin", "Admin", "Admin", "6000000006", roleAdmin);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
        userService.add(user6);
    }
}
