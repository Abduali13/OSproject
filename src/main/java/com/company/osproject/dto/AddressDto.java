package com.company.osproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Integer addressId;

    @NotNull(message = "Address number cannot be or empty")
    private Integer addressNumber;

    @NotBlank(message = "Zipcode cannot be null or empty")
    private String zipcode;

    @NotBlank(message = "Street cannot be null or empty")
    private String street;

    @NotBlank(message = "District cannot be null or empty")
    private String district;

    @NotBlank(message = "City cannot be null or empty")
    private String city;

    private HouseDto house;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
