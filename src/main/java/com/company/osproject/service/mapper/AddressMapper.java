package com.company.osproject.service.mapper;

import com.company.osproject.dto.AddressDto;
import com.company.osproject.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper{

    @Lazy
    @Autowired
    private HouseMapper houseMapper;

    public Address toEntity(AddressDto dto){
        return Address.builder()
                .addressNumber(dto.getAddressNumber())
                .zipcode(dto.getZipcode())
                .street(dto.getStreet())
                .district(dto.getDistrict())
                .city(dto.getCity())
                .houseId(dto.getHouseId())
                .build();
    }

    public AddressDto toDto(Address address){
        return AddressDto.builder()
                .addressId(address.getAddressId())
                .addressNumber(address.getAddressNumber())
                .zipcode(address.getZipcode())
                .street(address.getStreet())
                .district(address.getDistrict())
                .city(address.getCity())
                .houseId(address.getHouseId())
                .house(this.houseMapper.toDto(address.getHouse()))
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .deletedAt(address.getDeletedAt())
                .build();
    }

    public Address updateAddress(Address address, AddressDto addressDto){
        return null;
    }
}












//package com.company.osproject.service.mapper;
//import com.company.osproject.dto.AddressDto;
//import com.company.osproject.dto.HouseDto;
//import com.company.osproject.entity.Address;
//import com.company.osproject.entity.House;
//import org.mapstruct.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//
//@Mapper(componentModel = "spring", imports = {Collection.class, LocalDateTime.class}, uses = {HouseMapper.class})
//public abstract class AddressMapper {
//
//    @Lazy
//    @Autowired
//    private HouseMapper houseMapper;
//
//    @Mapping(target = "addressId", ignore = true)
//    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "house", ignore = true)
//    public abstract Address toEntity(AddressDto dto);
//
//    @Mapping(target = "house", ignore = true)
//    public abstract AddressDto toDto(Address address);
//
//    @Mapping(target = "house", expression = "java(this.houseMapper.toDto(address.getHouse()))")
//    public abstract AddressDto toDtoWithHouse(Address address);
//
//    @Mapping(target = "addressId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Address.class)
//    public abstract Address updateAddress(@MappingTarget Address address, AddressDto dto);
//}