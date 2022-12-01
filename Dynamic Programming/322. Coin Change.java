import java.util.Arrays;

public class coinChange {

    public int coinChangeOne(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int temp = Solve(coins, amount, coins.length - 1, dp);
        if (temp >= (int) Math.pow(10, 9))
            return -1;
        return temp;
    }

    public int Solve(int[] coins, int value, int index, int[][] dp) {
        if (index == 0) {
            if (value % coins[0] == 0)
                return value / coins[0];
            else
                return (int) Math.pow(10, 9);
        }
        if (dp[index][value] != -1)
            return dp[index][value];
        int notTake = Solve(coins, value, index - 1, dp);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= value) {
            take = 1 + Solve(coins, value - coins[index], index, dp);
        }
        return dp[index][value] = Math.min(take, notTake);
    }
}
