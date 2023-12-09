package com.company.osproject.repository;

import com.company.osproject.entity.House;
import com.company.osproject.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    Optional<House> findAllByHouseIdAndDeletedAtIsNull(Integer entityId);

    @Query(
            value = "select h from House as h where h.houseId=:id and h.deletedAt is null and :status like '%RENT' ",
            countQuery = "select count(h.houseId) from House as h where h.houseId=:id and h.deletedAt is null and :status like '%RENT' "
    )
    List<House> findHouseByHouseIdAndDeletedAtIsNullAndStatusIsForRent(@Param("id") Integer houseId, @Param("status")Status status);

    @Query(
            value = "select h from House as h where h.houseId=:id and h.deletedAt is null and :status like '%SALE' ",
            countQuery = "select count(h.houseId) from House as h where h.houseId=:id and h.deletedAt is null and :status like '%SALE' "
    )
    List<House> findHouseByHouseIdAndDeletedAtIsNullAndStatusIsForSale(@Param("id") Integer houseId, @Param("status")Status status);
}
