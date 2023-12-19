package com.company.osproject.service.mapper;

import com.company.osproject.dto.SaleDto;
import com.company.osproject.entity.House;
import com.company.osproject.entity.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper {

    private HouseMapper houseMapper;

    public Sale toEntity(SaleDto dto){
        return Sale.builder()
                .available(dto.isAvailable())
                .price(dto.getPrice())
                .soldDate(dto.getSoldDate())
                .build();
    }

    public SaleDto toDto(Sale sale){
        return SaleDto.builder()
                .saleId(sale.getSaleId())
                .houseId(sale.getHouseId())
                .available(sale.isAvailable())
                .price(sale.getPrice())
                .soldDate(sale.getSoldDate())
                .house(this.houseMapper.toDto(sale.getHouse()))
                .build();
    }
}
