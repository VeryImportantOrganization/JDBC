package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String PASSWORD = "1";
    private static final String USER = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static Connection connection;
//    private static SessionFactory sessionFactory;

    public static SessionFactory openSessionFactory() {
//        if (sessionFactory == null) {
            return new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
//        }
//        return sessionFactory;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection connect() throws SQLException {
        if (connection == null) {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}