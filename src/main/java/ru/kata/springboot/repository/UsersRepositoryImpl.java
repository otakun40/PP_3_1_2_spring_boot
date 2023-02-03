package ru.kata.springboot.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import ru.kata.springboot.model.User;
import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
    @PersistenceContext
    private EntityManager em;

    public UsersRepositoryImpl() {
    }

    @Override
    public User getById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(long id) {
        em.createQuery("delete from User u where u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }
}
