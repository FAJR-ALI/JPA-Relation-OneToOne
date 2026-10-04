package com.example.jparelationexersice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

    @Id
    private Integer id;

    @NotEmpty(message = "area cant be null")
    @Column(nullable = false)
    private String area;

    @NotEmpty(message = "street cant be null")
    @Column(nullable = false)
    private String street;

    @Positive(message = "Building number must be positive")
    @Column(nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private TeacherModel teacher;

}
