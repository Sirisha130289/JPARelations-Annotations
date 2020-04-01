package client;

import entity.movieManytoMany.Actor;
import entity.movieManytoMany.Movie;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

public class MovieApp {
    public static void main(String[] args) {

        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = persistenceProvider.
                createEntityManagerFactory("NewPersistenceUnit3", new HashMap());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Actor actor1 = new Actor("Christian Balle");
        Actor actor2 = new Actor("Hugh Jackman");

        Movie movie1 = new Movie("American Hustle");
        Movie movie2 = new Movie("The Prestige");

        movie1.getActors().add(actor1);

        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);

        entityManager.getTransaction().begin();
        entityManager.persist(movie1);
        entityManager.persist(movie2);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
