package com.orderely.restaurant.management.service;

import com.orderely.restaurant.management.DTO.request.AddressRequestDto;
import com.orderely.restaurant.management.DTO.response.AddressResponseDto;

import java.util.List;

public interface AddressService {
    AddressResponseDto createAddress(AddressRequestDto dto);
    List<AddressResponseDto>getAllAddresses();
    AddressResponseDto getAddressById(Long id);
    AddressResponseDto  updateAddress(Long id, AddressRequestDto dto);
    void deleteAddress(Long id);


}
