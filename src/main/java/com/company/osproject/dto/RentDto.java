package com.company.osproject.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

    private Integer rentId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    private HouseDto house;


}
