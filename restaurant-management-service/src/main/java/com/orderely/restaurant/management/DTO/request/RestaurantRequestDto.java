package com.orderely.restaurant.management.DTO.request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDto {

    @NotBlank(message = "Restaurant name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be valid")
    private String phone;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @NotNull(message = "Work start time is required")
    private LocalTime workAt;

    @NotNull(message = "Work close time is required")
    private LocalTime closeAt;

    @Valid
    @NotNull(message = "Address is required")
    private AddressRequestDto address;
}
