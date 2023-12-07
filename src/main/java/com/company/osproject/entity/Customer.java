package com.company.osproject.entity;

import com.company.osproject.entity.enums.CustomerRoles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(mappedBy = "customers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<House> house;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
