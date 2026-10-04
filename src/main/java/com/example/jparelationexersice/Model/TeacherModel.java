package com.example.jparelationexersice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 5, message = "Name must be at least 5 characters")
    @Column(name = "teacher_name", nullable = false)
    private String name;

    @NotNull
    @Min(value = 21, message = "Age must be 21 or older")
    @Column(name = "teacher_age", nullable = false)
    private Integer age;

    @NotEmpty
    @Email
    @Column(name = "teacher_email", nullable = false)
    private String email;

    @NotNull
    @Positive
    @Column(name = "teacher_salary", nullable = false)
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private AddressModel address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    @JsonIgnore
    private List<CourseModel> courses;
}
