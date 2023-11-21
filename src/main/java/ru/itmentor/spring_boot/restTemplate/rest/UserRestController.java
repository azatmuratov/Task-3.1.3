package ru.itmentor.spring_boot.restTemplate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring_boot.restTemplate.model.User;
import ru.itmentor.spring_boot.restTemplate.services.UserService;

import java.security.Principal;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/person")
    public ResponseEntity<User> userProfile(Principal principal) {
        User user = userService.findByLogin(principal.getName());
        return ResponseEntity.ok(user);
    }
}
