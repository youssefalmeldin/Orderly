package com.orderely.restaurant.management.repository;

import com.orderely.restaurant.management.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}