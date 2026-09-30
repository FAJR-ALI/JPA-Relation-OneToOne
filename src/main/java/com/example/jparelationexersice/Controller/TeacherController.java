package com.example.jparelationexersice.Controller;


import com.example.jparelationexersice.DTO.TeacherDTO;
import com.example.jparelationexersice.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody TeacherDTO teacher) {
        return ResponseEntity.status(200).body(teacherService.addTeacher(teacher));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @Valid @RequestBody TeacherDTO teacher) {
        return ResponseEntity.status(200).body(teacherService.updateTeacher(id, teacher));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}

