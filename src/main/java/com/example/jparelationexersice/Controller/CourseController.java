package com.example.jparelationexersice.Controller;

import com.example.jparelationexersice.Model.CourseModel;
import com.example.jparelationexersice.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addCourse(@PathVariable Integer teacherId, @Valid @RequestBody CourseModel course) {
        return ResponseEntity.status(200)
                .body(courseService.addCourse(teacherId, course));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @Valid @RequestBody CourseModel course) {
        return ResponseEntity.status(200).body(courseService.updateCourse(id, course));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted successfully");
    }

    @GetMapping("/{courseId}/teacher")
    public ResponseEntity<?> getTeacherName(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(courseId));
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<?> getStudents(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getStudents(courseId));
    }
}
