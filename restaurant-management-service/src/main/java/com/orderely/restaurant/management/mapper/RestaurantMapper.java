package com.orderely.restaurant.management.mapper;

import com.orderely.restaurant.management.DTO.request.RestaurantRequestDto;
import com.orderely.restaurant.management.DTO.response.RestaurantResponseDto;
import com.orderely.restaurant.management.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantMapper {

    private final AddressMapper addressMapper;

    public Restaurant toEntity(RestaurantRequestDto dto) {
        if (dto == null) return null;

        return Restaurant
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .phone(dto.getPhone())
                .active(dto.getActive())
                .workAt(dto.getWorkAt()).
                closeAt(dto.getCloseAt())
                .address(addressMapper.toEntity(dto.getAddress()))
                .build();
    }

    public RestaurantResponseDto toDto(Restaurant restaurant) {
        if (restaurant == null) return null;

        return RestaurantResponseDto
                .builder()
                .name(restaurant.getName())
                .description(restaurant.getDescription())
                .phone(restaurant.getPhone())
                .active(restaurant.getActive())
                .workAt(restaurant.getWorkAt())
                .closeAt(restaurant.getCloseAt())
                .address(addressMapper.toDto(restaurant.getAddress()))
                .build();
    }

     public void updateEntity(Restaurant restaurant, RestaurantRequestDto dto) {
        if (restaurant == null || dto == null) return;

        restaurant.setName(dto.getName());
        restaurant.setDescription(dto.getDescription());
        restaurant.setPhone(dto.getPhone());
        restaurant.setActive(dto.getActive());
        restaurant.setWorkAt(dto.getWorkAt());
        restaurant.setCloseAt(dto.getCloseAt());

        if (dto.getAddress() != null) {
            if (restaurant.getAddress() == null) {
                restaurant.setAddress(addressMapper.toEntity(dto.getAddress()));
            } else {
                addressMapper.updateEntity(restaurant.getAddress(), dto.getAddress());
            }
        }
    }
}
