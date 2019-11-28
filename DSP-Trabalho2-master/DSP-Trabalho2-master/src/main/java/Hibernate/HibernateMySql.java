package Hibernate;

import Entidades.*;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Aula
 */
public class HibernateMySql {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                Configuration config = new Configuration();

                //Hibernate settings: Equivalente ao hibernate.cfg.xml
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                setting.put(Environment.URL, "jdbc:mysql://localhost:3306/mysql");
                setting.put(Environment.USER, "root");
                setting.put(Environment.PASS, "admin");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

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
