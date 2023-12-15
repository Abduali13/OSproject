package com.company.osproject.dto;

import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {

    private Integer houseId;
    @NotBlank(message = "First name cannot be null or empty")
    private String nameOfBuilding;

    @NotNull(message = "Number of the house cannot be null or empty")
    private Integer numberOfHouse;

    @NotNull(message = "Number of rooms at house cannot be null or empty")
    private Integer numberOfRooms;

    @NotNull(message = "Numbers of floor cannot be null or empty")
    private Integer numberOfFloor;

    @NotNull(message = "Number of bedrooms cannot be null or empty")
    private Integer numberOfBedrooms;

    @NotNull(message = "Number of kitchens cannot be null or empty")
    private Integer numberOfKitchens;

    @NotNull(message = "Number of bathrooms cannot be null or empty")
    private Integer numberOfBathrooms;

    @NotNull(message = "Number of garages cannot be null or empty")
    private Integer numberOfGarages;

    @NotNull(message = "Number of parking slots cannot be null or empty")
    private Integer numberOfParkingSlots;

    @NotNull(message = "Size of the house cannot be null or empty")
    private Float size;

    @NotNull(message = "Price of house cannot be null or empty")
    private Long price;

    @NotBlank(message = "Some additional info must be given")
    private String additionalInfo;

    private String description;

    @Enumerated(EnumType.STRING)
    private Types types;

    @Enumerated(EnumType.STRING)
    private Status status;

    private AddressDto address;

    private SaleDto sale;

    private RentDto rent;

    private List<ImageDto> images;

    private List<CustomerDto> customers;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
