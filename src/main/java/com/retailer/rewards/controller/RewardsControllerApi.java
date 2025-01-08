package com.retailer.rewards.controller;

import com.retailer.rewards.model.Rewards;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RewardsControllerApi {
    @GetMapping(
            value = {"/{customerId}/rewards"},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<Rewards> getRewardsByCustomerId(
            @PathVariable("customerId") Long customerId);
}
