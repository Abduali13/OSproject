package com.company.osproject.service.mapper;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerMapper{

    @Lazy
    @Autowired
    private HouseMapper houseMapper;


    public Customer toEntity(CustomerDto dto){
        return Customer.builder()
                .age(dto.getAge())
                .email(dto.getEmail())
                .active(dto.isActive())
                .houseId(dto.getHouseId())
                .customerRoles(dto.getCustomerRoles())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();
    }

    public CustomerDto toDto(Customer customer){
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .age(customer.getAge())
                .active(customer.isActive())
                .customerRoles(customer.getCustomerRoles())
                .email(customer.getEmail())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .deletedAt(customer.getDeletedAt())
                .password(customer.getPassword())
                .build();
    }

    public CustomerDto toDtoWithParams(Customer customer){
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .age(customer.getAge())
                .active(customer.isActive())
                .customerRoles(customer.getCustomerRoles())
                .email(customer.getEmail())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .deletedAt(customer.getDeletedAt())
                .password(customer.getPassword())
                .houses(customer.getHouses().stream().map(this.houseMapper::toDto).collect(Collectors.toList()))
                .build();
    }

    public Customer updateCustomer(Customer customer, CustomerDto dto){
        if (dto.getFirstname() != null ){
            customer.setFirstname(dto.getFirstname());
        }
        if (dto.getLastname() != null ){
            customer.setLastname(dto.getLastname());
        }
        if (dto.getEmail() != null ){
            customer.setEmail(dto.getEmail());
        }
        if (dto.getPassword() != null ){
            customer.setPassword(dto.getPassword());
        }
        if (dto.getPhoneNumber() != null ){
            customer.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getAge() != null ){
            customer.setAge(dto.getAge());
        }
        if (dto.getUsername() != null ){
            customer.setUsername(dto.getUsername());
        }
        if (dto.getHouseId() != null ){
            customer.setHouseId(dto.getHouseId());
        }
        if (dto.getHouseId() != null ){
            customer.setHouseId(dto.getHouseId());
        }
        return customer;
    }
}










//package com.company.osproject.service.mapper;
//
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
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring", imports = {Collectors.class, LocalDateTime.class})
//public abstract class CustomerMapper {
//
//
//    @Lazy
//    @Autowired
//    protected HouseMapper houseMapper;
//
//    @Mapping(target = "customerId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "active", expression = "java(true)")
//    public abstract Customer toEntity(CustomerDto dto);
//
//    @Mapping(target = "houses", ignore = true)
//    public abstract CustomerDto toDto(Customer customer);
//
//    @Mapping(target = "houses", expression = "java(customer.getHouses().stream().map(this.houseMapper::toDto).collect(Collectors.toList()))")
//    public abstract CustomerDto toDtoWithHouse(Customer customer);
//
//
//    @Mapping(target = "customerId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "active", expression = "java(true)")
//    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Customer.class)
//    public abstract Customer updateCustomer(@MappingTarget Customer customer, CustomerDto dto);
//}