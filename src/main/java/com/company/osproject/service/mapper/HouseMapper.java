package com.company.osproject.service.mapper;


import com.company.osproject.dto.HouseDto;
import com.company.osproject.entity.House;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HouseMapper{

    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;
    private final SaleMapper saleMapper;
    private final RentMapper rentMapper;
    private final ImageMapper imageMapper;

    public House toEntity(HouseDto dto){
        return House.builder()
                .nameOfBuilding(dto.getNameOfBuilding())
                .numberOfHouse(dto.getNumberOfHouse())
                .numberOfRooms(dto.getNumberOfRooms())
                .numberOfFloor(dto.getNumberOfFloor())
                .numberOfBedrooms(dto.getNumberOfBedrooms())
                .numberOfKitchens(dto.getNumberOfKitchens())
                .numberOfBathrooms(dto.getNumberOfBathrooms())
                .numberOfGarages(dto.getNumberOfGarages())
                .numberOfParkingSlots(dto.getNumberOfParkingSlots())
                .size(dto.getSize())
                .price(dto.getPrice())
                .additionalInfo(dto.getAdditionalInfo())
                .description(dto.getDescription())
                .types(dto.getTypes())
                .status(dto.getStatus())
                .addressId(dto.getAddressId())
                .saleId(dto.getSaleId())
                .rentId(dto.getRentId())
                .imageId(dto.getImageId())
                .customerId(dto.getCustomerId()).build();
    }

    public HouseDto toDto(House house){
        return HouseDto.builder()
                .nameOfBuilding(house.getNameOfBuilding())
                .numberOfHouse(house.getNumberOfHouse())
                .numberOfRooms(house.getNumberOfRooms())
                .numberOfFloor(house.getNumberOfFloor())
                .numberOfBedrooms(house.getNumberOfBedrooms())
                .numberOfKitchens(house.getNumberOfKitchens())
                .numberOfBathrooms(house.getNumberOfBathrooms())
                .numberOfGarages(house.getNumberOfGarages())
                .numberOfParkingSlots(house.getNumberOfParkingSlots())
                .size(house.getSize())
                .price(house.getPrice())
                .additionalInfo(house.getAdditionalInfo())
                .description(house.getDescription())
                .types(house.getTypes())
                .status(house.getStatus())
                .addressId(house.getAddressId())
                .saleId(house.getSaleId())
                .rentId(house.getRentId())
                .imageId(house.getImageId())
                .customerId(house.getCustomerId())
                .createdAt(house.getCreatedAt())
                .updatedAt(house.getUpdatedAt())
                .deletedAt(house.getDeletedAt())
                .build();
    }

    public HouseDto toDtoWithParams(House house){
        return HouseDto.builder()
                .nameOfBuilding(house.getNameOfBuilding())
                .numberOfHouse(house.getNumberOfHouse())
                .numberOfRooms(house.getNumberOfRooms())
                .numberOfFloor(house.getNumberOfFloor())
                .numberOfBedrooms(house.getNumberOfBedrooms())
                .numberOfKitchens(house.getNumberOfKitchens())
                .numberOfBathrooms(house.getNumberOfBathrooms())
                .numberOfGarages(house.getNumberOfGarages())
                .numberOfParkingSlots(house.getNumberOfParkingSlots())
                .size(house.getSize())
                .price(house.getPrice())
                .additionalInfo(house.getAdditionalInfo())
                .description(house.getDescription())
                .types(house.getTypes())
                .status(house.getStatus())
                .addressId(house.getAddressId())
                .saleId(house.getSaleId())
                .rentId(house.getRentId())
                .imageId(house.getImageId())
                .customerId(house.getCustomerId())
                .address(this.addressMapper.toDto(house.getAddress()))
                .sale(this.saleMapper.toDto(house.getSale()))
                .rent(this.rentMapper.toDto(house.getRent()))
                .images(house.getImages().stream().map(this.imageMapper::toDto).collect(Collectors.toList()))
                .customers(this.customerMapper.toDto(house.getCustomers()))
                .createdAt(house.getCreatedAt())
                .updatedAt(house.getUpdatedAt())
                .deletedAt(house.getDeletedAt())
                .build();
    }

    public House updateHouse(House house, HouseDto dto){
        if (dto.getNameOfBuilding() != null) {
            house.setNameOfBuilding(dto.getNameOfBuilding());
        }
        if (dto.getNumberOfHouse() != null) {
            house.setNumberOfHouse(dto.getNumberOfHouse());
        }
        if (dto.getNumberOfRooms() != null) {
            house.setNumberOfRooms(dto.getNumberOfRooms());
        }
        if (dto.getNumberOfFloor() != null) {
            house.setNameOfBuilding(dto.getNameOfBuilding());
        }
        if (dto.getNumberOfFloor() != null) {
            house.setNumberOfFloor(dto.getNumberOfFloor());
        }
        if (dto.getNumberOfBedrooms() != null) {
            house.setNumberOfBedrooms(dto.getNumberOfBedrooms());
        }
        if (dto.getNumberOfKitchens() != null) {
            house.setNumberOfKitchens(dto.getNumberOfKitchens());
        }
        if (dto.getNumberOfBathrooms() != null) {
            house.setNumberOfBathrooms(dto.getNumberOfBathrooms());
        }
        if (dto.getNumberOfGarages() != null) {
            house.setNumberOfGarages(dto.getNumberOfGarages());
        }
        if (dto.getNumberOfParkingSlots() != null) {
            house.setNumberOfParkingSlots(dto.getNumberOfParkingSlots());
        }
        if (dto.getPrice() != null) {
            house.setPrice(dto.getPrice());
        }
        if (dto.getAdditionalInfo() != null) {
            house.setAdditionalInfo(dto.getAdditionalInfo());
        }
        if (dto.getDescription() != null) {
            house.setDescription(dto.getDescription());
        }
        if (dto.getTypes() != null) {
            house.setTypes(dto.getTypes());
        }
        if (dto.getStatus() != null) {
            house.setStatus(dto.getStatus());
        }
        return house;
    }

}