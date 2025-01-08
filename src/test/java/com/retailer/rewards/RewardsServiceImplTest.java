package com.retailer.rewards;

import com.retailer.rewards.entity.Transaction;
import com.retailer.rewards.model.Rewards;
import com.retailer.rewards.repository.TransactionRepository;
import com.retailer.rewards.service.RewardsServiceImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RewardsServiceImplTest {

    @Mock
    TransactionRepository transactionRepository;
    @InjectMocks
    private RewardsServiceImpl rewardsServiceImpl;

    @Test
    public void getRewardsByCustomerIdTest() throws Exception {
        final List<Transaction> transactions = new ArrayList<>();
        final Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setCustomerId(1000L);
        transaction.setTransactionAmount(120);
        transaction.setTransactionDate(Timestamp.valueOf(LocalDateTime.now()));
        transactions.add(transaction);
        Mockito.when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(Mockito.anyLong(),
                                                                                        Mockito.any(),
                                                                                        Mockito.any()))
                .thenReturn(transactions);
        Rewards customerRewards = rewardsServiceImpl.getRewardsByCustomerId(1000L);
        Assertions.assertNotNull(customerRewards);
    }
}
