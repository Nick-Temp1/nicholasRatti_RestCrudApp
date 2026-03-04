package com.example.hwStudent.service;

import com.example.hwStudent.entity.Student;
import com.example.hwStudent.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() { return studentRepository.findAll(); }

    public Student getStudentById(Long id) { return studentRepository.findById(id).orElse(null); }

    public Student addStudent(Student student) { return studentRepository.save(student); }

    public void deleteStudent(Long id) { studentRepository.deleteById(id); }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student stud = studentRepository.findById(id).orElse(null);
        if (stud != null) {
            stud.setName(updatedStudent.getName());
            stud.setFees(updatedStudent.getFees());
            stud.setSubName(updatedStudent.getSubName());
            return studentRepository.save(stud);
        }
        return null;
    }
}
