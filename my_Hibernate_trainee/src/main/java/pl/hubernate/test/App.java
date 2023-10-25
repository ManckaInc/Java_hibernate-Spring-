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

            //Save

            Person person = new Person("Rnd Name", 43);
            session.save(person);

            //Update

            Person personUpdate = session.get(Person.class,18);
            personUpdate.setName("AufWiedersehen");

            //Delete

            Person personDelete = session.get(Person.class, 16);
            session.delete(personDelete);


            session.getTransaction().commit();
        }

    }


}