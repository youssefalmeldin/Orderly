package com.orderely.restaurant.management.DTO.response;

import com.orderely.restaurant.management.DTO.request.AddressRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponseDto {
    private Long id;
    private String name;
    private String description;
    private String phone;
    private Boolean active;
    private LocalTime workAt;
    private LocalTime closeAt;
    private AddressResponseDto address;
}

