package ru.geekbrains.spring.one.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Student;

import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private List<Student> students;
    private static SessionFactory factory;

    @Autowired
    public StudentRepository (SessionFactory factory){
        this.factory = factory;
    }

    public List<Student> findAllFromData() {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            students = session.createQuery("from Student ").getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    public void addStudent(Student student) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public Optional<Student> findOneByIdFroData(Long id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return Optional.ofNullable(student);
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student students = session.get(Student.class, id);
            session.delete(students);
            session.getTransaction().commit();
        }
    }
}
