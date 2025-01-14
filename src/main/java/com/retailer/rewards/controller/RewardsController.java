package com.retailer.rewards.controller;

import com.retailer.rewards.entity.Customer;
import com.retailer.rewards.exception.CustomerNotFoundException;
import com.retailer.rewards.model.Rewards;
import com.retailer.rewards.repository.CustomerRepository;
import com.retailer.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RewardsController handles the all the customer related data
 *
 * @author Venkat
 */
@RestController
@RequestMapping("/customers")
public class RewardsController implements RewardsControllerApi {

    @Autowired
    RewardsService rewardsService;

    @Autowired
    CustomerRepository customerRepository;

    /**
     * getRewardsByCustomerId() handling the Rewards RewardPoints for each customer.
     *
     * @param customerId is the unique identifier of each customer
     * @return Rewards Points for individual customer.
     * @throws CustomerNotFoundException when given customer id is not available or invalid.
     */
    @Override
    public ResponseEntity<Rewards> getRewardsByCustomerId(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Invalid or Missing customer Id ");
        }
        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards,
                                    HttpStatus.OK);
    }

}
