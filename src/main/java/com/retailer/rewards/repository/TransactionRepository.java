package com.retailer.rewards.repository;

import com.retailer.rewards.entity.Transaction;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * TransactionRepository class to fetching all Transaction of each customer.
 * @author Venkat
 */
@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    /** findAllByCustomerId() fetching all Transaction for single customer
     * @param customerId is the unique identifier of each customer
     * @return List<Transaction> list of transaction for each customer.
     *
     */
    public List<Transaction> findAllByCustomerId(Long customerId);

    /** findAllByCustomerIdAndTransactionDateBetween() fetching all the Transaction by given date rage for each customer.
     * @param customerId is the unique identifier of each customer
     * @param from date of transaction
     * @param to date of transaction
     * @return List<Transaction> list of transaction for each customer.
     *
     */
    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId,
                                                                          Timestamp from,
                                                                          Timestamp to);
}
