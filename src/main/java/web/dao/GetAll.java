package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import web.Utils.CreateEntityManager;
import web.models.User;

import java.util.List;

public class GetAll {
    public static List<User> getAllUsers() {
        try (EntityManager em = CreateEntityManager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            List<User> users = em.createQuery("from User", User.class).getResultList();
            et.commit();
            return users;
        } catch (Exception e) {
            System.out.println("GetAll " + e);
        }
        return null;
    }
}
