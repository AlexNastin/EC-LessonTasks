package by.courses.java.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostgreSQLDatabaseManager implements DatabaseManager {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("userPersistenceUnit");

    private EntityManager entityManager;

    private PostgreSQLDatabaseManager() {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static DatabaseManager INSTANCE = new PostgreSQLDatabaseManager();
    }

    /**
     * The method gives singleton instance.
     */
    public static DatabaseManager getInstance() {
        return PostgreSQLDatabaseManager.Holder.INSTANCE;
    }
}
