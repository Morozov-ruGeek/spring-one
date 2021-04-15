package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Student;
import ru.geekbrains.spring.one.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findOneById(Long id) {
        return studentRepository.findOneById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    /*
     Альтернативный вариант кода, который я не додумался, как реализовать полностью

     public void alternativeIncrementScoreById(Long id){
        studentRepository.findOneById(id).get().setScore();
     }
     */

    
    public void incrementScoreById(Long id){
        studentRepository.incrementScoreById(id);
    }

    public void decrementScoreById(Long id){
        studentRepository.decrementScoreById(id);
    }

    public double getAverageScore() {
        return studentRepository.findAll().stream().mapToInt(Student::getScore).average().getAsDouble();
    }
}
