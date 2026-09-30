package com.example.jparelationexersice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {

    private String area;

    private String street;

    private Integer buildingNumber;
}
