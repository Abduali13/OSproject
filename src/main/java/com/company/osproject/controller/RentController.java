package com.company.osproject.controller;

import com.company.osproject.dto.RentDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rent")
@RequiredArgsConstructor
public class RentController {

    private RentService rentService;

    @GetMapping
    public ResponseDto<RentDto> rentApproval(Integer houseId){
        return this.rentService.rentApproval(houseId);
    }
}
