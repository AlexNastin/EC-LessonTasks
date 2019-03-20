package com.lesson8.connection;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionDB {

    private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/ncc_students";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";

    private ConnectionDB() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(POSTGRESQL_DRIVER);
            connection = DriverManager.getConnection(POSTGRESQL_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static ConnectionDB INSTANCE = new ConnectionDB();
    }

    /**
     * The method gives ConnectionDB singleton instance.
     */
    public static ConnectionDB getInstance() {
        return Holder.INSTANCE;
    }
}
