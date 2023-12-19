package com.company.osproject.service;

import com.company.osproject.dto.ResponseDto;
import com.company.osproject.dto.SaleDto;
import com.company.osproject.entity.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    @Autowired
    private final HouseService houseService;

    public ResponseDto<SaleDto> saleApproval(Integer houseId) {
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.FOR_SALE) {
            return ResponseDto.<SaleDto>builder()
                    .success(true)
                    .message("House for sale is approved")
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
