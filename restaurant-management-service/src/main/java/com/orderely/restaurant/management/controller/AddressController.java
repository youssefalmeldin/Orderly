package com.orderely.restaurant.management.controller;

import com.orderely.restaurant.management.DTO.request.AddressRequestDto;
import com.orderely.restaurant.management.DTO.response.AddressResponseDto;
import com.orderely.restaurant.management.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    //CREATE
    @PostMapping
    public ResponseEntity<AddressResponseDto> createAddress(@Valid @RequestBody AddressRequestDto addressRequestDto) {
        AddressResponseDto created = addressService.createAddress(addressRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //getALL
    @GetMapping
    public ResponseEntity<List<AddressResponseDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressRequestDto addressRequestDto) {
        AddressResponseDto updated = addressService.updateAddress(id, addressRequestDto);
        return ResponseEntity.ok(updated);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
