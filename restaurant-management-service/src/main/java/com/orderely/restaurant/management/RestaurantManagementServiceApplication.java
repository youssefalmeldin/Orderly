package com.orderely.restaurant.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestaurantManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementServiceApplication.class, args);
    }

}