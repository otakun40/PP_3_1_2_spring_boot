package ru.kata.springboot.service;

import jakarta.validation.Valid;
import ru.kata.springboot.model.User;
import java.util.List;

public interface UsersService {
    User getById(long id);
    List<User> getAll();

    void save(@Valid User user);

    void delete(long id);

    void update(@Valid User user);

}
