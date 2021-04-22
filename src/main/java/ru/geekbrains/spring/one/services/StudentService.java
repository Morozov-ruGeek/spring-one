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
        return studentRepository.findAllFromData();
    }

    public Optional<Student> findOneByIdFroData(Long id) {
        return studentRepository.findOneByIdFroData(id);
    }

    public void save(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void changeScoreById(Long id, int changeNumber){
        studentRepository.findOneByIdFroData(id).get().changeScore(changeNumber);
    }
}
