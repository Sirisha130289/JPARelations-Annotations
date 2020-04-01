package client;

import entity.person.Address;
import entity.person.Person;
import entity.studentManytoOne.Guide;
import entity.studentManytoOne.Student;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;


public class PersonApp {
    public static void main(String[] args) {


        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory emf = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit",
                new HashMap());
        EntityManager em = emf.createEntityManager();

        Address homeAddress = new Address("2000 E Main Street", "Seattle", "85123");
        Person person = new Person("Ruby", homeAddress);

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        emf.close();


    }
}