package pl.hubernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person1 = new Person("Test1", 21);
            Person person2 = new Person("Test2", 22);
            Person person3 = new Person("Test3", 23);

            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        }

    }


}