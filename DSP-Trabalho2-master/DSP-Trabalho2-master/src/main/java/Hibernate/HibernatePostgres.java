/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Entidades.Estudantes;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ktia-
 */
public class HibernatePostgres {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                Configuration config = new Configuration();

                //Hibernate settings: Equivalente ao hibernate.cfg.xml
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "org.postgresql.Driver");
                setting.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                setting.put(Environment.USER, "postgres");
                setting.put(Environment.PASS, "admin");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                setting.put(Environment.AUTOCOMMIT, "false");

                setting.put(Environment.SHOW_SQL, "true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                setting.put(Environment.HBM2DDL_AUTO, "update");

                config.setProperties(setting);

                //Mapeamento das Classes
                config.addAnnotatedClass(Estudantes.class);

                ServiceRegistry service = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties()).build();

                sessionFactory = config.buildSessionFactory(service);

            } catch (Exception e) {

                System.out.println("Error on Utils: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
