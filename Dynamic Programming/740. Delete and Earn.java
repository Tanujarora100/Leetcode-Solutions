package DP.DayThree;

import java.util.Arrays;

public class deleteAndEarnProblem {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] houses = new int[n]; // houses array will act as a house robber problem
        for (int num : nums) {
            houses[num] += num;
        }
        // Populating each house as the value of i-1 +i.
        return rob(houses);
    }

    int rob(int[] houses) {
        // int[] dp = new int[houses.length + 1];
        // Arrays.fill(dp, -1);
        int n = houses.length;
        return DP(houses, n);
    }

    int DP(int[] nums, int n) {
        int dp[] = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int include = nums[i];
            if (i > 1) {
                include = include + dp[i - 2];
            }
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }

    int helper(int houses[], int dp[], int index) {
        if (index == 0)
            return houses[0];
        if (index == 1)
            return Math.max(houses[0], houses[1]);
        if (dp[index] != -1)
            return dp[index];
        return dp[index] = Math.max(houses[index] + helper(houses, dp, index - 2), helper(houses, dp, index - 1));
    }

    int spaceOptimized(int[] houses, int n) {
        int prev = houses[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            long pick = houses[0];
            if (i > 1)
                pick += prev2;
            long nonPick = 0 + prev;

            int cur_i = (int) Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;

        }
        return (int) prev;
    }
}
