package com.company.osproject.dto;

import com.company.osproject.entity.enums.CustomerRoles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String username;
    private String password;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private CustomerRoles customerRoles;

    private List<HouseDto> houses;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
