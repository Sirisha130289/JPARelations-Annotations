package entity.studentManytoOne;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "enrollment_id", nullable = false)
    private String enrollmentId;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "guide_id")
    private Guide guide;   //student to guide is a many to one relationship


    public Student() {
    }

    public Student(String enrollmentId, String name, Guide guide) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Id.equals(student.Id) &&
                enrollmentId.equals(student.enrollmentId) &&
                name.equals(student.name) &&
                guide.equals(student.guide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, enrollmentId, name, guide);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", enrollmentId='" + enrollmentId + '\'' +
                ", name='" + name + '\'' +
                ", guide=" + guide +
                '}';
    }
}
