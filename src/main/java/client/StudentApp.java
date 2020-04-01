package client;

import entity.studentManytoOne.Guide;
import entity.studentManytoOne.Student;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

public class StudentApp {
    public static void main(String[] args) {
        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory emf1 = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit1",
                new HashMap());
        EntityManager em1 = emf1.createEntityManager();
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 10000);
        Guide guide2 = new Guide("2000MO10856", "Neel Lamb", 10200);
        Guide guide3 = new Guide("2000MO17856", "Harry Johnson", 13000);
        Student student1 = new Student("2014IT50123", "John Smith", guide1);
        Student student2 = new Student("2014IT50523", "Amy Neilmonds", guide1);
        Student student3 = new Student("2014IT25523", "Jack Sparrow", guide3);
        Student student4 = new Student("2014IT50023", "Tony Blair", guide3);

        guide1.getStudents().add(student1);
        guide1.getStudents().add(student2);
        guide3.getStudents().add(student3);
        guide3.getStudents().add(student4);

        em1.getTransaction().begin();
//        em1.persist(guide1);
//        em1.persist(guide2);
        em1.persist(guide3);
//        Student student1 = em1.find(Student.class, 2l);
//        em1.remove(student1);
//        em1.getTransaction().commit();
//        emf1.close();

        Guide guide = em1.find(Guide.class,2l);
        Student student = em1.find(Student.class,2l);

        guide.setSalary(15000);
        // guide.getStudents().add(student);
        guide.addStudent(student);
        em1.getTransaction().commit();
        emf1.close();
    }
}
