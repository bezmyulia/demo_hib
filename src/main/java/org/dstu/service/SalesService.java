package org.dstu.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.security.auth.login.Configuration;
import java.util.List;

public class SalesService {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure(); // загружает настройки из hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Object> fetchData(String SQL) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Object> result = session.createQuery(SQL).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
