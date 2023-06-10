package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.openSessionFactory().openSession()) {
            session.beginTransaction();
            String SQL = "CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(50), lastName VARCHAR(50), age INT)";
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.openSessionFactory().openSession()) {
            session.beginTransaction();
            String SQL = "DROP TABLE IF EXISTS users";
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.openSessionFactory().openSession()){
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.openSessionFactory().openSession()){
            session.beginTransaction();
            session.createQuery("delete User where id = (" + id + ")").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try (Session session = Util.openSessionFactory().openSession()) {
            session.beginTransaction();
            users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
//            users = session.createQuery("from User").getResultList();
////            users.forEach(System.out::println);
//            session.getTransaction().commit();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.openSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
