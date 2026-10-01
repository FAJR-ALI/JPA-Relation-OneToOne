package com.example.jparelationexersice.Service;


import com.example.jparelationexersice.ApiResponse.ApiException;
import com.example.jparelationexersice.Model.StudentModel;
import com.example.jparelationexersice.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = studentRepository.findAll();
        if (students.isEmpty()) {
            throw new ApiException("There is no Students yet");
        }
        return students;
    }

    public StudentModel addStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    public StudentModel updateStudent(Integer id, StudentModel student) {
        StudentModel oldStudent = studentRepository.findById(id).orElse(null);
        if (oldStudent == null) {
            throw new ApiException("No Student found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        return studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        StudentModel student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new ApiException("No Student found");
        }
        studentRepository.delete(student);
    }

    public StudentModel changeMajor(Integer id, String major) {
        StudentModel student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("No Student found");
        }
        student.setMajor(major);
        student.getCourses().clear();
        return studentRepository.save(student);
    }
}
