package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import web.Utils.CreateEntityManager;
import web.models.User;

public class Update {
    public static void updateUser(User user) {
        try (EntityManager em = CreateEntityManager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("Ошибка в update " + e);
        }
    }
}