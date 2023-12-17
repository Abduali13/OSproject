package com.company.osproject.repository;

import com.company.osproject.entity.Customer;
import com.company.osproject.entity.enums.CustomerRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Optional<Customer> findCustomerByCustomerIdAndDeletedAtIsNull(Integer customerId);

//    Optional<Customer> findCustomerByCustomerIdAndDeletedAtIsNullAndActiveIsTrue(Integer customerId);

    @Query(
            value = "select c from Customer as c where c.customerId = coalesce(:customerId, c.customerId) " +
                    " and c.firstname = coalesce(:firstname, c.firstname) " +
                    " and c.lastname = coalesce(:lastname, c.lastname) " +
                    " and c.email = coalesce(:email, c.email) " +
                    " and c.phoneNumber = coalesce(:phoneNumber, c.phoneNumber) " +
                    " and c.age = coalesce(:age, c.age) " +
                    " and c.username = coalesce(:username, c.username) " +
                    " and c.customerRoles = coalesce(:customerRoles, c.customerRoles) ",
            countQuery = "select count(*) from Customer as c where c.customerId = coalesce(:customerId, c.customerId) " +
                    " and c.firstname = coalesce(:fisrtname, c.firstname) " +
                    " and c.lastname = coalesce(:lastname, c.lastname) " +
                    " and c.email = coalesce(:email, c.email) " +
                    " and c.phoneNumber = coalesce(:phoneNumber, c.phoneNumber) " +
                    " and c.age = coalesce(:age, c.age) " +
                    " and c.username = coalesce(:username, c.username) " +
                    " and c.customerRoles = coalesce(:customerRoles, c.customerRoles) "
    )
    Page<Customer> getCustomersWithMoreParams(
            @Param(value = "customerId") Integer customerId,
            @Param(value = "firstname") String firstname,
            @Param(value = "lastname") String lastname,
            @Param(value = "email") String email,
            @Param(value = "phoneNumber") String phoneNumber,
            @Param(value = "age") Integer age,
            @Param(value = "username") String username,
            @Param(value = "customerRoles") CustomerRoles customerRoles,
            Pageable pageable
            );
}
