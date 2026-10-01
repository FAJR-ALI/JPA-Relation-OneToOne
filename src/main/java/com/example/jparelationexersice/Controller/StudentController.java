package com.example.jparelationexersice.Controller;


import com.example.jparelationexersice.Model.StudentModel;
import com.example.jparelationexersice.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentModel student) {
        return ResponseEntity.status(200).body(studentService.addStudent(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentModel student) {
        return ResponseEntity.status(200).body(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }

    @PutMapping("/{id}/major")
    public ResponseEntity<?> changeMajor(@PathVariable Integer id, @RequestParam String major) {
        return ResponseEntity.status(200).body(studentService.changeMajor(id, major));
    }
}

