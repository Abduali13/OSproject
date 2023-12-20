package com.company.osproject.entity;

import com.company.osproject.entity.enums.CustomerRoles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String username;
    private String password;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private CustomerRoles customerRoles;

    @Column(name = "house_id")
    private Integer houseId;

    @OneToMany(mappedBy = "customers",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<House> houses; // todo: Customer class need to be mapped to House

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
