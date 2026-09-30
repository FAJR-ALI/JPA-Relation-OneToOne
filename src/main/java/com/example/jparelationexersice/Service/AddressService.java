package com.example.jparelationexersice.Service;

import com.example.jparelationexersice.ApiResponse.ApiException;
import com.example.jparelationexersice.DTO.AddressDTO;
import com.example.jparelationexersice.Model.AddressModel;
import com.example.jparelationexersice.Model.TeacherModel;
import com.example.jparelationexersice.Repository.AddressRepository;
import com.example.jparelationexersice.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<AddressModel> getAll() {
        List<AddressModel> add = addressRepository.findAll();
        if (add.isEmpty()) {
            throw new ApiException("No Address yet");
        }
        return add;
    }

    public AddressModel addAddress(Integer teacherId, AddressDTO addressDTO) {

        TeacherModel teacherModel = teacherRepository.findById(teacherId).orElse(null);
        if (teacherModel == null) {
            throw new ApiException("No Teacher With This id");
        }
        if (teacherModel.getAddress() != null) {
            throw new ApiException("The Teacher Already have an address");
        }
        AddressModel add = new AddressModel();
        add.setArea(addressDTO.getArea());
        add.setStreet(addressDTO.getStreet());
        add.setBuildingNumber(addressDTO.getBuildingNumber());

        return addressRepository.save(add);
    }

    public AddressModel updateAddress(Integer teacherId, AddressDTO addressDTO) {
        AddressModel add = addressRepository.findById(teacherId).orElse(null);
        if (add == null) {
            throw new ApiException("No Address found");
        }
        add.setArea(addressDTO.getArea());
        add.setStreet(addressDTO.getStreet());
        add.setBuildingNumber(addressDTO.getBuildingNumber());
        return addressRepository.save(add);
    }

    public void deleteAddress(Integer id){
        AddressModel add = addressRepository.findById(id).orElse(null);
        if(add == null){
            throw new ApiException("Not Teacher found");
        }
        addressRepository.delete(add);
    }
}