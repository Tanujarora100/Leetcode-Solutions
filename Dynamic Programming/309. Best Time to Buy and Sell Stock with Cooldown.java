
import java.util.Arrays;

public class buyandSellWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Solve(prices, 0, 1, dp);
    }

    public static int Solve(int[] arr, int n, int buy, int[][] dp) {
        if (n >= arr.length)
            return 0;
        int maxProfit = 0;
        if (dp[n][buy] != -1)
            return dp[n][buy];
        if (buy == 1) {
            maxProfit = Math.max(-arr[n] + Solve(arr, n + 1, 0, dp), 0 + Solve(arr, n + 1, 1, dp));
        }
        // Writing Selling Case here.
        else {
            maxProfit = Math.max(arr[n] + Solve(arr, n + 2, 1, dp), 0 + Solve(arr, n + 1, 0, dp));
        }
        return dp[n][buy] = maxProfit;
    }

    // Using State Machine.
    public int spaceOptimized(int[] prices) {

        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }
}
