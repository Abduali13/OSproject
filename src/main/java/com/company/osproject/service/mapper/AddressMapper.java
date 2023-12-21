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
    protected HouseMapper houseMapper;

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

    public Address updateAddress(Address address, AddressDto dto){
        if (dto.getAddressNumber() != null){
            address.setAddressNumber(dto.getAddressNumber());
        }
        if (dto.getZipcode() != null){
            address.setZipcode(dto.getZipcode());
        }
        if (dto.getStreet() != null){
            address.setStreet(dto.getStreet());
        }
        if (dto.getDistrict() != null){
            address.setDistrict(dto.getCity());
        }
        if (dto.getHouseId() != null){
            address.setHouseId(dto.getHouseId());
        }
        return address;
    }
}
