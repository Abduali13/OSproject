package com.company.osproject.dto;

import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
import jakarta.persistence.*;
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
    private String nameOfBuilding;
    private Integer numberOfHouse;
    private Integer numberOfRooms;
    private Integer numberOfFlat;
    private Integer numberOfBedrooms;
    private Integer numberOfKitchens;
    private Integer numberOfBathrooms;
    private Integer numberOfGarages;
    private Integer numberOfParkingSlots;
    private Float size;
    private Long price;
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
