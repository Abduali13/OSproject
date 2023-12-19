package com.company.osproject.controller;

import com.company.osproject.dto.ResponseDto;
import com.company.osproject.dto.SaleDto;
import com.company.osproject.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sale")
@RequiredArgsConstructor
public class SaleController {
    private SaleService saleService;
    @GetMapping
    public ResponseDto<SaleDto> saleApproval(Integer houseId){
        return this.saleService.saleApproval(houseId);
    }
}
