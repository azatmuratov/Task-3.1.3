package ru.itmentor.spring_boot.restTemplate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring_boot.restTemplate.model.User;
import ru.itmentor.spring_boot.restTemplate.services.RoleService;
import ru.itmentor.spring_boot.restTemplate.services.UserService;


import java.security.Principal;
import java.util.List;

@RestController
public class AdminRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/people")
    public ResponseEntity<List<User>> showTable() {
        List<User> usersList = userService.listUsers();
        return ResponseEntity.ok(usersList);
    }

  
    @GetMapping("/admin/people/new")
    public ResponseEntity<String> newUser() {
        roleService.listRoles();
        return ResponseEntity.ok("User new successfully Roles");
    }
//
    @PostMapping("/admin/people")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/admin/people/{id}/edit")
    public ResponseEntity<User> editUser(@PathVariable("id") long id) {
        User user = userService.getById(id);
        if (user != null) {
            user.setPassword("");
            return ResponseEntity.ok(user);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/admin/people/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable long id) {
        User user1 = userService.getById(id);
        if (user1 == null) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userService.update(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/admin/people/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        userService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
