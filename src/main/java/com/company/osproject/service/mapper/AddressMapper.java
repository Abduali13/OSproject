package com.company.osproject.service.mapper;

import com.company.osproject.dto.AddressDto;
import com.company.osproject.entity.Address;
import jakarta.validation.constraints.Null;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Mapper(componentModel = "spring", imports = {Collection.class, LocalDateTime.class})
public abstract class AddressMapper {


    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "house", ignore = true)
    public abstract Address toEntity(AddressDto dto);

    @Mapping(target = "house", ignore = true)
    public abstract AddressDto toDto(Address address);


    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Address.class)
    public abstract Address updateAddress(@MappingTarget Address address, AddressDto dto);
}
