package com.orderely.restaurant.management.mapper;

import com.orderely.restaurant.management.DTO.request.AddressRequestDto;
import com.orderely.restaurant.management.DTO.response.AddressResponseDto;
import com.orderely.restaurant.management.model.Address;
import org.springframework.stereotype.Component;
@Component
public class AddressMapper {

    public Address toEntity(AddressRequestDto dto) {
        if (dto == null) return null;

        return Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry())
                .build();
    }

    public AddressResponseDto toDto(Address address) {
        if (address == null) return null;

        return AddressResponseDto.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .build();
    }
    public void updateEntity(Address address, AddressRequestDto dto) {
        if (address == null || dto == null) return;

        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());
    }
}
