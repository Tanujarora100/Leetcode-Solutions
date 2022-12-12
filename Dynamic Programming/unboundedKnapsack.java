import java.util.Arrays;

public class unboundedKnapsack {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N + 1][W + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return knapsackUtil(wt, val, N, W, dp);
    }

    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {

        if (ind == 0) {
            if (wt[0] <= W)
                return val[0];
            else
                return 0;
        }
        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }

    static int unboundedKnapsackTabulation(int n, int W, int[] val, int[] wt) {

        int[][] dp = new int[n][W + 1];

        // Base Condition

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = ((int) i / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTaken = 0 + dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W];
    }
