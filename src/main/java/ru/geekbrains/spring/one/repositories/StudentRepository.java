package ru.geekbrains.spring.one.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(Arrays.asList(
                new Student(1L, "John", 80),
                new Student(2L, "Jack", 90),
                new Student(3L, "Bob", 100),
                new Student(4L, "Max", 90)
        ));
    }

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }

    public Optional<Student> findOneById(Long id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    public void incrementScoreById(Long id){
        for (Student s : students) {
            if (s.getId().equals(id)) {
                 s.setScore(s.getScore()+1);
            }
        }
    }

    public void decrementScoreById(Long id){
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.setScore(s.getScore()-1);
            }
        }
    }
}
