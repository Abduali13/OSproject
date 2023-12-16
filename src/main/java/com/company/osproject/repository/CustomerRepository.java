package com.company.osproject.repository;

import com.company.osproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Optional<Customer> findCustomerByCustomerIdAndDeletedAtIsNull(Integer customerId);

    Optional<Customer> findCustomerByCustomerIdAndDeletedAtIsNullAndActiveIsTrue(Integer customerId);
}
