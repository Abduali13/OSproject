package com.company.osproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private Integer saleId;

    @NotBlank(message = "Sold date cannot be null or empty")
    private LocalDate soldDate;

    @NotNull(message = "Sold price cannot be null or empty")
    private Long price;

    private boolean available;

    private HouseDto house;


}
