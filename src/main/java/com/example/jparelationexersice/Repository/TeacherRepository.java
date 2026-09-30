package com.example.jparelationexersice.Repository;

import com.example.jparelationexersice.Model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Integer> {

}
