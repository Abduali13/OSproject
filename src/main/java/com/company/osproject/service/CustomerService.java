package com.company.osproject.service;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.Customer;
import com.company.osproject.repository.CustomerRepository;
import com.company.osproject.service.mapper.CustomerMapper;
import com.company.osproject.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService implements SimpleCrud<CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public ResponseDto<CustomerDto> createEntity(CustomerDto dto) {
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
                        .content(this.customerMapper.toDto(customer))
                        .build())
                .orElse(ResponseDto.<CustomerDto>builder()
                        .code(-1)
                        .message(String.format("Customer with this %d is not found", entityId)).build());
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
}
