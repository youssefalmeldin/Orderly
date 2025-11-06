package com.orderely.restaurant.management.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {

    @NotBlank(message = "Street must not be blank")
    @Size(max = 100, message = "Street name too long")
    private String street;

    @NotBlank(message = "City must not be blank")
    private String city;

    @NotBlank(message = "State must not be blank")
    private String state;

    @NotBlank(message = "Postal code must not be blank")
    private String postalCode;

    @NotBlank(message = "Country must not be blank")
    private String country;
}
