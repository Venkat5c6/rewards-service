package com.retailer.rewards;

import com.retailer.rewards.entity.Transaction;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionTest {

    @Test
    public void transactionTest() throws Exception {
        final Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setCustomerId(1000L);
        transaction.setTransactionAmount(120);
        transaction.setTransactionDate(Timestamp.valueOf(LocalDateTime.now()));
        Assertions.assertNotNull(transaction);
        Assertions.assertEquals(transaction.getTransactionAmount(),
                                120);
    }
}
