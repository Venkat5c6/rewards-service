package com.retailer.rewards;

import com.retailer.rewards.model.Rewards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RewardsTest {
    @Test
    public void rewardsTest() throws Exception {
        final Rewards rewards = new Rewards();
        rewards.setTotalRewards(200);
        rewards.setLastMonthRewardPoints(100);
        rewards.setLastSecondMonthRewardPoints(50);
        rewards.setLastThirdMonthRewardPoints(50);
        rewards.setCustomerId(1001L);
        Assertions.assertNotNull(rewards);
        Assertions.assertEquals(rewards.getTotalRewards(),
                                200);
    }
}
