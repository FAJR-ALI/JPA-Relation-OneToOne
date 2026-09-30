package com.example.jparelationexersice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
    private String area;

    @NotNull(message = "street cant be null")
    private String street;

    @Positive
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private TeacherModel teacher;

}
