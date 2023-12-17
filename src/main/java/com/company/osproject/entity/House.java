package com.company.osproject.entity;


import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
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
@Table(name = "houses")
public class House {

    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;
    private String nameOfBuilding;
    private Integer numberOfHouse;
    private Integer numberOfRooms;
    private Integer numberOfFloor;
    private Integer numberOfBedrooms;
    private Integer numberOfKitchens;
    private Integer numberOfBathrooms;
    private Integer numberOfGarages;
    private Integer numberOfParkingSlots;
    private Float size;
    private Long price;
    private String additionalInfo;
    private String description;

    @Enumerated(EnumType.STRING)
    public Types types;

    @Enumerated(EnumType.STRING)
    public Status status;

//    @Column(name = "address_id")
//    private Integer addressId;
//
//    @Column(name = "sale_id")
//    private Integer saleId;
//
//    @Column(name = "rent_id")
//    private Integer rentId;
//
//    @Column(name = "image_id")
//    private Integer imageId;
//
//    @Column(name = "customer_id")
//    private Integer customerId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private Sale sale;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_id", insertable = false, updatable = false)
    private Rent rent;

    @OneToMany(mappedBy = "house",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private List<Customer> customers;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
