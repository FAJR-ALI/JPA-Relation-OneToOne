package com.example.jparelationexersice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;

    @NotNull
    @Min(value = 21, message = "Age must be 21 or older")
    private Integer age;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Positive
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private AddressModel address;

}
