package com.example.jparelationexersice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeacherDTO {

    private String name;

    private Integer age;

    private String email;

    private Double salary;
}
