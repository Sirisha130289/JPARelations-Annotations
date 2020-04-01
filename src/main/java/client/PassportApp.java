package client;

import entity.passportOneToOne.Customer;
import entity.passportOneToOne.Passport;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

public class PassportApp {
    public static void main(String[] args) {

        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = persistenceProvider.
                createEntityManagerFactory("NewPersistenceUnit2", new HashMap());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Passport passport = new Passport("123456789");
        Customer customer = new Customer("Alexis", passport);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
}
