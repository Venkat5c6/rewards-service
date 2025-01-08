package com.retailer.rewards.repository;

import com.retailer.rewards.entity.Transaction;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    public List<Transaction> findAllByCustomerId(Long customerId);

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId,
                                                                          Timestamp from,
                                                                          Timestamp to);
}
