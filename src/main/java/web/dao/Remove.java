package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import web.Utils.CreateEntityManager;
import web.models.User;

public class Remove {
    public static void removeUserById(long id) {
        try (EntityManager em = CreateEntityManager.openConnect()) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            User user = em.find(User.class, id);
            em.remove(user);
            et.commit();
        } catch (Exception e) {
            System.out.println("Ошибка в removeUserById " + e);
        }
    }
}
