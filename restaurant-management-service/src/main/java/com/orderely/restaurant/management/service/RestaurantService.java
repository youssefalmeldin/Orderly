package com.orderely.restaurant.management.service;

import com.orderely.restaurant.management.DTO.request.RestaurantRequestDto;
import com.orderely.restaurant.management.DTO.response.RestaurantResponseDto;

import java.util.List;

public interface RestaurantService {

    RestaurantResponseDto getRestaurantById(Long id);

    List<RestaurantResponseDto> getAllRestaurants();

    void deleteRestaurant(Long id);

    RestaurantResponseDto updateRestaurant(Long id, RestaurantRequestDto dto);

    RestaurantResponseDto createRestaurant(RestaurantRequestDto dto);
}
