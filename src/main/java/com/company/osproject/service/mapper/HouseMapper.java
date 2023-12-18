package com.company.osproject.service.mapper;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.entity.House;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, LocalDateTime.class})
public abstract class HouseMapper {

    @Lazy
    @Autowired
    protected AddressMapper addressMapper;

    @Lazy
    @Autowired
    protected CustomerMapper customerMapper;


    @Mapping(target = "houseId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "customers", ignore = true)
    public abstract House toEntity(HouseDto dto);


    @Mapping(target = "address", ignore = true)
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "rent", ignore = true)
    @Mapping(target = "images", ignore = true)
    public abstract HouseDto toDto(House house);


    @Mapping(target = "address", expression = "java(this.addressMapper.toDto(house.getAddress()))")
    @Mapping(target = "customers", expression = "java(house.getCustomers().stream().map(this.customerMapper::toDto).collect(Collectors.toList()))")
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "rent", ignore = true)
    @Mapping(target = "images", ignore = true)
    public abstract HouseDto toDtoWithAddress(House house);


    @Mapping(target = "houseId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = House.class)
    public abstract House updateHouse(@MappingTarget House house, HouseDto dto);
}
