package com.company.osproject.service;

import com.company.osproject.dto.ResponseDto;
import com.company.osproject.dto.SaleDto;
import com.company.osproject.entity.Sale;
import com.company.osproject.entity.enums.Status;
import com.company.osproject.repository.SaleRepository;
import com.company.osproject.service.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaleService {

    @Autowired
    private final HouseService houseService;
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public ResponseDto<SaleDto> saleApproval(Integer houseId) {
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.FOR_SALE) {
            Sale sale = new Sale(1, LocalDate.now(), 20000L, true, 1, houseService.getHouse(houseId));
            return ResponseDto.<SaleDto>builder()
                    .success(true)
                    .message("House for sale is approved")
                    .content(this.saleMapper.toDto(this.saleRepository.save(sale)))
                    .build();
        }
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.SOLD) {
            return ResponseDto.<SaleDto>builder()
                    .success(true)
                    .message("House is already sold")
                    .build();
        }
        return ResponseDto.<SaleDto>builder()
                .code(-1)
                .message(String.format("Cannot find house with this %d id", houseId))
                .build();
    }
}
