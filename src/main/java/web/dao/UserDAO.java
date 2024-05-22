package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import web.Utils.CreateEntityManager;
import web.models.User;

import java.util.List;

@Repository
public class UserDAO implements IUserDAO {
    private final CreateEntityManager manager;

    public UserDAO() {
        this.manager = new CreateEntityManager();
    }

    @Override
    public User getUserById(int id) {
        try (EntityManager em = manager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            User user = em.find(User.class, id);
            et.commit();
            return user;
        } catch (Exception e) {
            System.out.println("Ошибка в get " + e);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try (EntityManager em = manager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            List<User> users = em.createQuery("from User", User.class).getResultList();
            et.commit();
            return users;
        } catch (Exception e) {
            System.out.println("Ошибка в GetAll " + e);
        }
        return null;
    }

    @Override
    public void removeUserById(long id) {
        try (EntityManager em = manager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            User user = em.find(User.class, id);
            em.remove(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("Ошибка в removeUserById " + e);
        }
    }

    @Override
    public void saveUser(User user) {
        try (EntityManager em = manager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("GetAll " + e);
        }
    }

    @Override
    public void updateUser(User user) {
        try (EntityManager em = manager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("Ошибка в update " + e);
        }
    }
}
