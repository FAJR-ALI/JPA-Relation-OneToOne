package com.example.jparelationexersice.Repository;

import com.example.jparelationexersice.Model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer> {

}
