package ru.itmentor.spring_boot.restTemplate.services;






import ru.itmentor.spring_boot.restTemplate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void remove(long id);
    void update(User user);
    User getById(long id);
    User findByLogin(String login);
    List<User> listUsers();
}
