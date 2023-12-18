package com.company.osproject.service.mapper;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.entity.Customer;
import com.company.osproject.entity.House;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, LocalDateTime.class})
public abstract class CustomerMapper {


    @Autowired
    protected HouseMapper houseMapper;

    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "houses", ignore = true)
    @Mapping(target = "active", expression = "java(true)")
    public abstract Customer toEntity(CustomerDto dto);

    @Mapping(target = "houses", ignore = true)
    public abstract CustomerDto toDto(Customer customer);

    @Mapping(target = "houses", expression = "java(customer.getHouses().stream().map(this.houseMapper::toDto).collect(Collectors.toList()))")
    public abstract CustomerDto toDtoWithHouse(Customer customer);

//    public void simple(Customer customer, House house){
//        CustomerDto customerDto = new CustomerDto();
//        customer.getHouses().stream().map(this.houseMapper::toDto).collect(Collectors.toSet());
//    }

    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "active", expression = "java(true)")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Customer.class)
    public abstract Customer updateCustomer(@MappingTarget Customer customer, CustomerDto dto);
}
