package com.example.jparelationexersice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Age can't be null")
    private Integer age;

    @NotEmpty(message = "Major can't be empty")
    private String major;

    @ManyToMany
    @JsonIgnore
    private List<CourseModel> courses;

}
