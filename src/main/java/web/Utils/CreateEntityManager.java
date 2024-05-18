package web.Utils;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class CreateEntityManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_pu");

    public EntityManager openConnect() {
        return emf.createEntityManager();
    }
}
