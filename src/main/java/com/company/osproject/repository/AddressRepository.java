package com.company.osproject.repository;

import com.company.osproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findAllByAddressIdAndDeletedAtIsNull(Integer addressId);
}
