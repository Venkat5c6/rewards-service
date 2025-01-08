package com.retailer.rewards;

import com.retailer.rewards.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {
    @Test
    public void customerTest() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1000L);
        customer.setCustomerName("Venkat");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(customer.getCustomerId(),
                                1000L);
    }
}
