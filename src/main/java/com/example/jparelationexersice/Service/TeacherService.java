package com.example.jparelationexersice.Service;

import com.example.jparelationexersice.ApiResponse.ApiException;
import com.example.jparelationexersice.DTO.TeacherDTO;
import com.example.jparelationexersice.Model.TeacherModel;
import com.example.jparelationexersice.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherModel> getAllTeachers(){
        List<TeacherModel> allTeachers = teacherRepository.findAll();
        if(allTeachers.isEmpty()){
            throw new ApiException("There is no Teachers yet");
        }
        return allTeachers;
    }

    public TeacherModel addTeacher(TeacherDTO teacher){

        TeacherModel teacherModel = new TeacherModel();

        teacherModel.setName(teacher.getName());
        teacherModel.setAge(teacher.getAge());
        teacherModel.setEmail(teacher.getEmail());
        teacherModel.setSalary(teacher.getSalary());

        return teacherRepository.save(teacherModel);
    }

    public TeacherModel updateTeacher(Integer id, TeacherDTO teacher){
        TeacherModel t = teacherRepository.findById(id).orElse(null);
        if(t == null){
            throw new ApiException("Not Teacher found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        return teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        TeacherModel t = teacherRepository.findById(id).orElse(null);
        if(t == null){
            throw new ApiException("Not Teacher found ");
        }
        teacherRepository.delete(t);
    }

    public TeacherModel getTeacherDetails(Integer id) {
        TeacherModel teacher = teacherRepository.findById(id).orElse(null);
        if (teacher == null) {
            throw new ApiException("Not Teacher found");
        }
        return teacher;
    }
}
