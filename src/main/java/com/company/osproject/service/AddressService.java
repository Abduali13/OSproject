package com.company.osproject.service;


import com.company.osproject.dto.AddressDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.repository.AddressRepository;
import com.company.osproject.service.mapper.AddressMapper;
import com.company.osproject.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AddressService implements SimpleCrud<AddressDto, Integer> {


    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Override
    public ResponseDto<AddressDto> createEntity(AddressDto dto) {
        try {
            return ResponseDto.<AddressDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.addressMapper.toDto(
                                    this.addressRepository.save(
                                            this.addressMapper.toEntity(dto))
                            )
                    )
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AddressDto>builder()
                    .code(-2)
                    .message(String.format("Error occurred while saving address, message: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<AddressDto> getEntity(Integer entityId) {
        return this.addressRepository.findAllByAddressIdAndDeletedAtIsNull(entityId)
                .map(address -> ResponseDto.<AddressDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.addressMapper.toDto(address))
                        .build())
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message(String.format("Address with this %d is not found", entityId)).build());
    }


    public ResponseDto<AddressDto> get(Integer entityId) {
        return this.addressRepository.findAllByAddressIdAndDeletedAtIsNull(entityId)
                .map(address -> ResponseDto.<AddressDto>builder()
                        .success(true)
                        .message("OK")
                        .content(this.addressMapper.toDto(address))
                        .build())
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message(String.format("Address with this %d is not found", entityId)).build());
    }

    @Override
    public ResponseDto<AddressDto> updateEntity(Integer entityId, AddressDto dto) {
        return this.addressRepository.findAllByAddressIdAndDeletedAtIsNull(entityId)
                .map(address ->
                     ResponseDto.<AddressDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.addressMapper.toDto(this.addressRepository.save(this.addressMapper.updateAddress(address, dto))))
                            .build()
                )
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message(String.format("Address with this %d is not found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<AddressDto> deleteEntity(Integer entityId) {
        return this.addressRepository.findAllByAddressIdAndDeletedAtIsNull(entityId)
                .map(address -> {
                    address.setDeletedAt(LocalDateTime.now());
                    return ResponseDto.<AddressDto>builder()
                            .success(true)
                            .message("OK")
                            .content(this.addressMapper.toDto(this.addressRepository.save(address)))
                            .build();
                })
                .orElse(ResponseDto.<AddressDto>builder()
                        .code(-1)
                        .message(String.format("Address with this %d is not found", entityId))
                        .build());
    }
}
