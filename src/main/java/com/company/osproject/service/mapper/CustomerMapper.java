package com.company.osproject.service.mapper;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.entity.Customer;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Mapper(componentModel = "spring", imports = {Collection.class, LocalDateTime.class})
public abstract class CustomerMapper {

    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "houses", ignore = true)
    @Mapping(target = "active", expression = "java(true)")
    public abstract Customer toEntity(CustomerDto dto);

    @Mapping(target = "houses", ignore = true)
    public abstract CustomerDto toDto(Customer customer);

    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "active", expression = "java(true)")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Customer.class)
    public abstract Customer updateCustomer(@MappingTarget Customer customer, CustomerDto dto);
}
