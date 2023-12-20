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
        return null;
    }

}



//package com.company.osproject.service.mapper;
//
//import com.company.osproject.dto.CustomerDto;
//import com.company.osproject.dto.HouseDto;
//import com.company.osproject.entity.Customer;
//import com.company.osproject.entity.House;
//import org.mapstruct.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//
//import java.time.LocalDateTime;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring", imports = {Collectors.class, LocalDateTime.class})
//public abstract class HouseMapper {
//
//    @Lazy
//    @Autowired
//    protected AddressMapper addressMapper;
//
//    @Lazy
//    @Autowired
//    protected CustomerMapper customerMapper;
//
//
//    @Mapping(target = "houseId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    public abstract House toEntity(HouseDto dto);
//
//
//    @Mapping(target = "address", ignore = true)
//    @Mapping(target = "customers", ignore = true)
//    @Mapping(target = "sale", ignore = true)
//    @Mapping(target = "rent", ignore = true)
//    @Mapping(target = "images", ignore = true)
//    public abstract HouseDto toDto(House house);
//
//
//    @Mapping(target = "address", expression = "java(this.addressMapper.toDto(house.getAddress()))")
//    @Mapping(target = "customers", expression = "java(this.customerMapper.toDto(house.getCustomers()))")
//    @Mapping(target = "sale", ignore = true)
//    @Mapping(target = "rent", ignore = true)
//    @Mapping(target = "images", ignore = true)
//    public abstract HouseDto toDtoWithAddress(House house);
//
//    @Mapping(target = "houseId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = House.class)
//    public abstract House updateHouse(@MappingTarget House house, HouseDto dto);
//}