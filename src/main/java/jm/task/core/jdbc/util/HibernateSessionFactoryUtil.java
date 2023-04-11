package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        Configuration configuration = new Configuration().configure();
        try {
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("Исключение: " + e);
        }
        return sessionFactory;
    }
}
