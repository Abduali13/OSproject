package com.company.osproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long price;
    private boolean active;

    @Column(name = "house_id")
    private Integer houseId;

    @OneToOne(mappedBy = "rent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private House house;


}
