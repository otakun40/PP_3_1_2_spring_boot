package ru.kata.springboot.service;

import ru.kata.springboot.model.User;
import java.util.List;

public interface UsersService {
    User getById(long id);
    List<User> getAll();

    void save(User user);

    void delete(long id);

    void update(User user);

}
