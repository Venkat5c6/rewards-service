package com.retailer.rewards.repository;

import com.retailer.rewards.entity.Customer;
import org.springframework.data.repository.CrudRepository;
/**
 * CustomerRepository class to fetch the Customer date.
 * @author Venkat
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    /** findByCustomerId() fetch the customer data
     * @param customerId is the unique identifier of each customer
     * @return Customer details.
     *
     */
    public Customer findByCustomerId(Long customerId);
}
