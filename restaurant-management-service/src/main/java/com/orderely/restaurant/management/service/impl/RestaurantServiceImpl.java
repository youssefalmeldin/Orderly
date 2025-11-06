package com.orderely.restaurant.management.service.impl;

import com.orderely.restaurant.management.DTO.request.RestaurantRequestDto;
import com.orderely.restaurant.management.DTO.response.RestaurantResponseDto;
import com.orderely.restaurant.management.exception.ResourceNotFoundException;
import com.orderely.restaurant.management.mapper.RestaurantMapper;
import com.orderely.restaurant.management.model.Restaurant;
import com.orderely.restaurant.management.repository.RestaurantRepository;
import com.orderely.restaurant.management.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private  final RestaurantMapper restaurantMapper;
    private  final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponseDto createRestaurant(RestaurantRequestDto dto) {
        Restaurant restaurant = restaurantMapper.toEntity(dto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toDto(savedRestaurant);
    }

    @Override
    public RestaurantResponseDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        return restaurantMapper.toDto(restaurant);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public RestaurantResponseDto updateRestaurant(Long id, RestaurantRequestDto dto) {
       Restaurant existing =restaurantRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        restaurantMapper.updateEntity(existing,dto);
        Restaurant updated =restaurantRepository.save(existing);
        return  restaurantMapper.toDto(updated);
    }


    @Override
    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)){
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);
    }
}
