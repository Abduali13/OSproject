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
public class RentDto {

    private Integer rentId;

    @NotBlank(message = "Rent start date cannot be null or empty")
    private LocalDate startDate;

    @NotBlank(message = "Rent end date cannot be null or empty")
    private LocalDate endDate;

    @NotNull(message = "Rent price cannot be null or empty")
    private Long price;

    private boolean active;

    private HouseDto house;


}
