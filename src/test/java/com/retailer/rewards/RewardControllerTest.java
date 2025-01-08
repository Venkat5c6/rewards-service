package com.retailer.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.retailer.rewards.controller.RewardsController;
import com.retailer.rewards.entity.Customer;
import com.retailer.rewards.exception.CustomerNotFoundException;
import com.retailer.rewards.exception.RestException;
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

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    private RewardsController rewardController;
    @Mock
    private RewardsService rewardsService;

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

        when(customerRepository.findByCustomerId(Mockito.anyLong())).thenReturn(customer);
        when(rewardsService.getRewardsByCustomerId(Mockito.anyLong())).thenReturn(rewards);
        final ResponseEntity<Rewards> response = rewardController.getRewardsByCustomerId(10001L);
        assertEquals(response.getStatusCode().value(),
                     200);
        assertEquals(response.getBody().getCustomerId(),
                     10001L);
    }

    @Test
    public void getRewardsByCustomerId_trowException_when_customer_nullTest() throws Exception {
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

        when(customerRepository.findByCustomerId(Mockito.anyLong())).thenReturn(null);
        when(rewardsService.getRewardsByCustomerId(Mockito.anyLong())).thenReturn(rewards);
        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class,
                                                           () -> {
                                                               rewardController.getRewardsByCustomerId(10001L);
                                                           });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void getRewardsByCustomerId_when_ThrowExceptionTest() {
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

        doThrow(new CustomerNotFoundException("Invalid or Missing customer Id")).when(customerRepository)
                .findByCustomerId(10001L);
        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class,
                                                           () -> {
                                                               rewardController.getRewardsByCustomerId(10001L);
                                                           });
        assertEquals("Invalid or Missing customer Id",
                     exception.getMessage());

    }


}
