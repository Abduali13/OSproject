package com.company.osproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {

    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;

    private LocalDate soldDate;
    private Long price;
    private boolean available;

    @OneToOne(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private House house;




}
