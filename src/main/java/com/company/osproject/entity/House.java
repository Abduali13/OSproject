package com.company.osproject.entity;


import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.Registered;
import lombok.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "houses")
public class House {

    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;
    private Integer numberOfHouse;
    private Integer numberOfRooms;
    private Integer numberOfFlats;
    private Integer numberOfBedrooms;
    private Integer numberOfKitchens;
    private Integer numberOfBathrooms;
    private Integer numberOfGarages;
    private Integer numberOfParkingSlots;
    private Float size;



//    @Enumerated(EnumType.STRING)
//    private Types types;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;

    private String additionalInfo;
    private Long price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_id", insertable = false, updatable = false)
    private Rent rent;

    @OneToMany(mappedBy = "house",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Image> images;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
