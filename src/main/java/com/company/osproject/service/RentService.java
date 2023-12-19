package com.company.osproject.service;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.RentDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.House;
import com.company.osproject.entity.Rent;
import com.company.osproject.entity.enums.Status;
import com.company.osproject.repository.RentRepository;
import com.company.osproject.service.mapper.RentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentService {

    @Autowired
    private HouseService houseService;
    private RentRepository rentRepository;
    private RentMapper rentMapper;

    public ResponseDto<RentDto> rentApproval(Integer houseId){
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.FOR_RENT){
            Rent rent = new Rent(1, LocalDate.now(), LocalDate.of(2024, 12, 19), 200000L,true, houseId, this.houseService.getHouse(houseId));
            return ResponseDto.<RentDto>builder()
                    .success(true)
                    .message("House for rent is approved")
                    .content(this.rentMapper.toDto(this.rentRepository.save(rent))).build();
        }
        if (this.houseService.getEntity(houseId).getContent().getStatus() == Status.RENTED){
            return ResponseDto.<RentDto>builder()
                    .success(true)
                    .message("House is already rented")
                    .build();
        }
        return ResponseDto.<RentDto>builder()
                .code(-1)
                .message(String.format("Cannot find house with this %d id", houseId))
                .build();
    }

}
