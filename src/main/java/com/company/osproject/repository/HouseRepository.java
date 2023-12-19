package com.company.osproject.repository;

import com.company.osproject.entity.House;
import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {


    House findByHouseId(Integer houseId);

    Optional<House> findAllByTypes(Types types);

    Optional<House> findAllByDeletedAtIsNull();

    Optional<House> findAllByHouseIdAndDeletedAtIsNull(Integer entityId);

    @Query(
            value = "select h from House as h where h.houseId=:id and h.deletedAt is null and :status like '%RENT' ",
            countQuery = "select count(h.houseId) from House as h where h.houseId=:id and h.deletedAt is null and :status like '%RENT' "
    )
    List<House> findHouseByHouseIdAndDeletedAtIsNullAndStatusIsForRent(@Param("id") Integer houseId, @Param("status") Status status);

    @Query(
            value = "select h from House as h where h.houseId=:id and h.deletedAt is null and :status like '%SALE' ",
            countQuery = "select count(h.houseId) from House as h where h.houseId=:id and h.deletedAt is null and :status like '%SALE' "
    )
    List<House> findHouseByHouseIdAndDeletedAtIsNullAndStatusIsForSale(@Param("id") Integer houseId, @Param("status") Status status);


    @Query(
            value = "select h from House as h where h.houseId = coalesce(:houseId, h.houseId) " +
                    " and h.nameOfBuilding = coalesce(:nameOfBuilding, h.nameOfBuilding) " +
                    " and h.numberOfHouse = coalesce(:numberOfHouse, h.numberOfHouse) " +
                    " and h.numberOfRooms = coalesce(:numberOfRooms, h.numberOfRooms) " +
                    " and h.numberOfFloor = coalesce(:numberOfFloor, h.numberOfFloor) " +
                    " and h.numberOfBedrooms = coalesce(:numberOfBedrooms, h.numberOfBedrooms) " +
                    " and h.numberOfKitchens = coalesce(:numberOfKitchens, h.numberOfKitchens)" +
                    " and h.numberOfBathrooms = coalesce(:numberOfBathrooms, h.numberOfBathrooms)" +
                    " and h.numberOfGarages = coalesce(:numberOfGarages, h.numberOfGarages) " +
                    " and h.numberOfParkingSlots = coalesce(:numberOfParkingSlots, h.numberOfParkingSlots)" +
                    " and h.size = coalesce(:size, h.size) " +
                    " and h.price = coalesce(:price, h.price) " +
                    " and h.additionalInfo = coalesce(:additionalInfo, h.additionalInfo) " +
                    " and h.description = coalesce(:description, h.description) " +
                    " and h.types = coalesce(:types, h.types) " +
                    " and h.status = coalesce(:status, h.status) ",
            countQuery = "select count(*) from House as h where h.houseId = coalesce(:houseId, h.houseId) " +
                    " and h.nameOfBuilding = coalesce(:nameOfBuilding, h.nameOfBuilding) " +
                    " and h.numberOfHouse = coalesce(:numberOfHouse, h.numberOfHouse) " +
                    " and h.numberOfRooms = coalesce(:numberOfRooms, h.numberOfRooms) " +
                    " and h.numberOfFloor = coalesce(:numberOfFloor, h.numberOfFloor) " +
                    " and h.numberOfBedrooms = coalesce(:numberOfBedrooms, h.numberOfBedrooms) " +
                    " and h.numberOfKitchens = coalesce(:numberOfKitchens, h.numberOfKitchens)" +
                    " and h.numberOfBathrooms = coalesce(:numberOfBathrooms, h.numberOfBathrooms)" +
                    " and h.numberOfGarages = coalesce(:numberOfGarages, h.numberOfGarages) " +
                    " and h.numberOfParkingSlots = coalesce(:numberOfParkingSlots, h.numberOfParkingSlots)" +
                    " and h.size = coalesce(:size, h.size) " +
                    " and h.price = coalesce(:price, h.price) " +
                    " and h.additionalInfo = coalesce(:additionalInfo, h.additionalInfo) " +
                    " and h.description = coalesce(:description, h.description) " +
                    " and h.types = coalesce(:types, h.types) " +
                    " and h.status = coalesce(:status, h.status) ")
    Page<House> getHousesWithMoreParams(
            @Param(value = "houseId") Integer houseId,
            @Param(value = "nameOfBuilding") String nameOfBuilding,
            @Param(value = "numberOfHouse") Integer numberOfHouse,
            @Param(value = "numberOfRooms") Integer numberOfRooms,
            @Param(value = "numberOfFloor") Integer numberOfFloor,
            @Param(value = "numberOfBedrooms") Integer numberOfBedrooms,
            @Param(value = "numberOfKitchens") Integer numberOfKitchens,
            @Param(value = "numberOfBathrooms") Integer numberOfBathrooms,
            @Param(value = "numberOfGarages") Integer numberOfGarages,
            @Param(value = "numberOfParkingSlots") Integer numberOfParkingSlots,
            @Param(value = "size") Float size,
            @Param(value = "price") Long price,
            @Param(value = "additionalInfo") String additionalInfo,
            @Param(value = "description") String description,
            @Param(value = "types") Types types,
            @Param(value = "status") Status status,
            Pageable pageable
    );


}
