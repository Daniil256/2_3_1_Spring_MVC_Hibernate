package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import web.Utils.CreateEntityManager;
import web.models.User;

public class Get {
    public static User getUserById(int id) {
        try (EntityManager em = CreateEntityManager.openConnect()) {
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
}
