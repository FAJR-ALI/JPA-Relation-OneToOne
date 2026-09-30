package com.example.jparelationexersice.Controller;

import com.example.jparelationexersice.DTO.AddressDTO;
import com.example.jparelationexersice.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addAddress(@PathVariable Integer teacherId, @Valid @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(200).body(addressService.addAddress(teacherId, addressDTO));
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer teacherId, @Valid @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(200).body(addressService.updateAddress(teacherId, addressDTO));
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer teacherId) {
        addressService.deleteAddress(teacherId);
        return ResponseEntity.status(200).body("Address deleted successfully");
    }
}

