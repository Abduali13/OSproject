package com.company.osproject.service;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.dto.ErrorDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.House;
import com.company.osproject.entity.enums.CustomerRoles;
import com.company.osproject.repository.CustomerRepository;
import com.company.osproject.repository.HouseRepository;
import com.company.osproject.service.mapper.CustomerMapper;
import com.company.osproject.service.mapper.HouseMapper;
import com.company.osproject.service.validation.CustomerValidation;
import com.company.osproject.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements SimpleCrud<CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerValidation customerValidation;


    @Override
    public ResponseDto<CustomerDto> createEntity(CustomerDto dto) {
        List<ErrorDto> errors = this.customerValidation.customerValid(dto);
        if (!errors.isEmpty()){
            return ResponseDto.<CustomerDto>builder()
                    .code(-3)
                    .message("Customer validation error")
                    .build();
        }
        try {
            return ResponseDto.<CustomerDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.customerMapper.toDto(
                                    this.customerRepository.save(
                                            this.customerMapper.toEntity(dto))
                            )
                    )
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CustomerDto>builder()
                    .code(-2)
                    .message(String.format("Error occurred while creating customer, message: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<CustomerDto> getEntity(Integer entityId) {
        return this.customerRepository.findCustomerByCustomerIdAndDeletedAtIsNull(entityId)
                .map(customer -> ResponseDto.<CustomerDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.customerMapper.toDtoWithParams(customer))
                        .build())
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message(String.format("Customer with this %d is not found", entityId))
                        .build());
    }

    public ResponseDto<CustomerDto> get(Integer entityId) {
        return this.customerRepository.findCustomerByCustomerIdAndDeletedAtIsNull(entityId)
                .map(customer -> ResponseDto.<CustomerDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.customerMapper.toDto(customer))
                        .build())
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message(String.format("Customer with this %d is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<CustomerDto> updateEntity(Integer entityId, CustomerDto dto) {
        return this.customerRepository.findCustomerByCustomerIdAndDeletedAtIsNull(entityId)
                .map(customer-> ResponseDto.<CustomerDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.customerMapper.toDto(this.customerRepository.save(this.customerMapper.updateCustomer(customer, dto))))
                        .build())
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message(String.format("Customer with this %d is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<CustomerDto> deleteEntity(Integer entityId) {
        return this.customerRepository.findCustomerByCustomerIdAndDeletedAtIsNull(entityId)
                .map(customer-> {
                    customer.setDeletedAt(LocalDateTime.now());
                    return ResponseDto.<CustomerDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.customerMapper.toDto(this.customerRepository.save(customer)))
                            .build();})
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message(String.format("Customer with this %d is not found", entityId))
                        .build());
    }

    public ResponseDto<Page<CustomerDto>> getCustomersWithParams(Map<String, String> params, CustomerRoles customerRoles) {
        int size = 10, page = 0;
        if (params.containsKey("size")){
            size = Integer.parseInt(params.get("size"));
        }
        if (params.containsKey("page")){
            page = Integer.parseInt(params.get("page"));
        }
        return ResponseDto.<Page<CustomerDto>>builder()
                .success(true)
                .message("OK")
                .content(
                        this.customerRepository.getCustomersWithMoreParams(
                                params.get("customerId") == null ? null : Integer.parseInt(params.get("customerId")),
                                params.get("firstname"), params.get("lastname"), params.get("email"),
                                params.get("phoneNumber"),
                                params.get("age") == null ? null : Integer.parseInt(params.get("age")),
                                params.get("username"),
                                customerRoles,
                                PageRequest.of(page, size)
                        ).map(this.customerMapper::toDto)
                ).build();
    }
}
