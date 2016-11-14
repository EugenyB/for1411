package dao;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by eugeny on 13.11.2016.
 */
@Stateless
public class UserDAO {
    @PersistenceContext
    EntityManager em;

    public User find(String login){
        return em.find(User.class, login);
    }

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
}
