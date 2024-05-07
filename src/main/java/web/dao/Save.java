package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import web.Utils.CreateEntityManager;
import web.models.User;

public class Save {
    public static void saveUser(User user) {
        try (EntityManager em = CreateEntityManager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("GetAll " + e);
        }
    }
}
