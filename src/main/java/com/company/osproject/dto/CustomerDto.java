package com.company.osproject.dto;

import com.company.osproject.entity.enums.CustomerRoles;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private Integer customerId;

    @NotBlank(message = "First name cannot be null or empty")
    private String firstname;

    @NotBlank(message = "Last name cannot be null or empty")
    private String lastname;

    @NotBlank(message = "Email cannot be null or empty")
    private String email;

    @NotBlank(message = "Phone number cannot be null or empty")
    private String phoneNumber;

    @NotNull(message = "Age cannot be null or empty")
    private Integer age;

    @NotBlank(message = "Username cannot be null or empty")
    private String username;

    @NotBlank(message = "Password cannot be null or empty")
    private String password;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private CustomerRoles customerRoles;

    private Integer houseId;

    private List<HouseDto> houses;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
