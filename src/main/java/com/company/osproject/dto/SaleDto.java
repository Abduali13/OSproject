package com.company.osproject.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private Integer saleId;
    private LocalDate soldDate;
    private Long price;
    private boolean available;

    private HouseDto house;


}
