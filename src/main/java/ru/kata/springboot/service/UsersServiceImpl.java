package ru.kata.springboot.service;

import jakarta.validation.Valid;
import ru.kata.springboot.repository.UsersRepository;
import ru.kata.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User getById(long id) {
        return usersRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return usersRepository.getAll();
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public void delete(long id) {
        usersRepository.delete(id);
    }

    @Override
    public void update(@Valid User user) {
        usersRepository.update(user);
    }
}
