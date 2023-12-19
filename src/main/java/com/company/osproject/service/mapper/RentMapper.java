package com.company.osproject.service.mapper;

import com.company.osproject.dto.RentDto;
import com.company.osproject.entity.Rent;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    private HouseMapper houseMapper;
    public Rent toEntity(RentDto dto){
        return Rent.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .active(dto.isActive())
                .price(dto.getPrice())
                .build();
    }

    public RentDto toDto(Rent rent){
        return RentDto.builder()
                .rentId(rent.getRentId())
                .active(rent.isActive())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .price(rent.getPrice())
                .house(this.houseMapper.toDto(rent.getHouse()))
                .build();
    }
}
