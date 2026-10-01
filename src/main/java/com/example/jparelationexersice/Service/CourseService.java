package com.example.jparelationexersice.Service;

import com.example.jparelationexersice.ApiResponse.ApiException;
import com.example.jparelationexersice.Model.CourseModel;
import com.example.jparelationexersice.Model.StudentModel;
import com.example.jparelationexersice.Model.TeacherModel;
import com.example.jparelationexersice.Repository.CourseRepository;
import com.example.jparelationexersice.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseModel> getAllCourses() {
        List<CourseModel> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            throw new ApiException("There is no Courses yet");
        }
        return courses;
    }

    public CourseModel addCourse(Integer teacherId, CourseModel course) {
        TeacherModel teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher == null) {
            throw new ApiException("No Teacher with this id");
        }
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    public CourseModel updateCourse(Integer id, CourseModel course) {
        CourseModel oldCourse = courseRepository.findById(id).orElse(null);
        if (oldCourse == null) {
            throw new ApiException("No Course found");
        }
        oldCourse.setName(course.getName());
        return courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        CourseModel course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            throw new ApiException("No Course found");
        }
        courseRepository.delete(course);
    }

    public String getTeacherName(Integer courseId) {
        CourseModel course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new ApiException("No Course found");
        }
        return course.getTeacher().getName();
    }

    public List<StudentModel> getStudents(Integer courseId) {
        CourseModel course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new ApiException("No Course found");
        }
        return course.getStudents();
    }

}
