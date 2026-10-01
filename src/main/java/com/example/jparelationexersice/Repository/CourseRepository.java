package com.example.jparelationexersice.Repository;

import com.example.jparelationexersice.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Integer> {

}
