package web.Utils;

import jakarta.persistence.*;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.stereotype.Component;
import web.config.PersistenceUnit;

import java.util.HashMap;

@Component
public class CreateEntityManager {
    private final EntityManagerFactory emf =
            new HibernatePersistenceProvider()
                    .createContainerEntityManagerFactory(new PersistenceUnit(), new HashMap<>());

    public EntityManager openConnect() {
        return emf.createEntityManager();
    }
}
