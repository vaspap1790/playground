package org.example;

import java.util.Arrays;

public class DPProblems {

    public static int minCoinsChange(int[] coins, int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Adding one extra row on top so that we have values to compare for our first coin
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);

        for(int i = 1; i < dp.length; i++){
            dp[i][0] = 0;
            for(int j = 1; j < dp[0].length; j++){
                // j (index) being the amount
                // i - 1 because of the extra row we added (using the same i for coins and dp)
                if(coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];    // copy the value of the cell above it - we don't pick the coin
                } else {
                    // we pick the coin, so we need the min of the value above
                    // and
                    // 1(picked coin) plus the number of coins needed for amount - coin
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        return dp[coins.length][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
    }

    public static int minCoinsChangeOptimizedSpace(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE );
        dp[0] = 0;

        for (int c : coins){
            for (int i = c; i <= amount; i++) {
                if (dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
