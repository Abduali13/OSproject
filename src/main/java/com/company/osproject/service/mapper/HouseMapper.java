package com.company.osproject.service.mapper;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.entity.Address;
import com.company.osproject.entity.House;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Collection;

@Mapper(componentModel = "spring", imports = {Collection.class, LocalDateTime.class})
public abstract class HouseMapper {

    @Autowired
    public AddressMapper addressMapper;

    @Mapping(target = "houseId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "customers", ignore = true)
    public abstract House toEntity(HouseDto dto);


    @Mapping(target = "address", ignore = true)
    public abstract HouseDto toDto(House house);


    @Mapping(target = "houseId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = House.class)
    public abstract House updateHouse(@MappingTarget House house, HouseDto dto);
}
