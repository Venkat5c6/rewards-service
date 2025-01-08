package com.retailer.rewards;

import com.retailer.rewards.controller.RewardsController;
import com.retailer.rewards.entity.Customer;
import com.retailer.rewards.model.Rewards;
import com.retailer.rewards.repository.CustomerRepository;
import com.retailer.rewards.service.RewardsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class RewardControllerTest {

    @InjectMocks
    private RewardsController rewardController;
    @Mock
    private RewardsService rewardsService;
    @Mock
    CustomerRepository customerRepository;

    @Test
    public void getRewardsByCustomerIdTest() throws Exception {
        //customer date
        Customer customer = new Customer();
        customer.setCustomerId(10001L);
        customer.setCustomerName("Venkat");
        //Rewards data
        Rewards rewards = new Rewards();
        rewards.setCustomerId(10001L);
        rewards.setLastMonthRewardPoints(120);
        rewards.setLastSecondMonthRewardPoints(10);
        rewards.setLastThirdMonthRewardPoints(20);

        Mockito.when(customerRepository.findByCustomerId(Mockito.anyLong())).thenReturn(customer);
        Mockito.when(rewardsService.getRewardsByCustomerId(Mockito.anyLong())).thenReturn(rewards);
        final ResponseEntity<Rewards> response = rewardController.getRewardsByCustomerId(10001L);
        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(response.getBody().getCustomerId(), 10001L);
    }


}
