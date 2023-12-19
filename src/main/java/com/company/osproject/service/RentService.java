package com.company.osproject.service;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.RentDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentService {

    @Autowired
    private HouseService houseService;

    public ResponseDto<RentDto> rentApproval(Integer houseId){
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.FOR_RENT){
            return ResponseDto.<RentDto>builder()
                    .success(true)
                    .message("House for rent is approved")
                    .content(null).build();
        }
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.RENTED){
            return ResponseDto.<RentDto>builder()
                    .success(true)
                    .message("House is already rented")
                    .content(null).build();
        }
        return ResponseDto.<RentDto>builder()
                .code(-1)
                .message(String.format("Cannot find house with this %d id", houseId))
                .build();
    }
}
