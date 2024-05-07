package web.Utils;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class CreateEntityManager {
    private EntityManager entityManager;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_pu");

    public static EntityManager openConnect() {
        return emf.createEntityManager();
    }
}
