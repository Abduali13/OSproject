package com.company.osproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Integer addressId;
    private Integer addressNumber;
    private String zipcode;
    private String street;
    private String district;
    private String city;

    private HouseDto house;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
