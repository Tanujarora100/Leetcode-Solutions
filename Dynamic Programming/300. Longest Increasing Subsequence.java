
import java.util.Arrays;

public class printLCS {
    static int longestSubsequence(int size, int a[]) {
        if (size == 1)
            return 0;
        // 1 element is not an Increasing Subsequence.
        int[][] dp = new int[size][size + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return longestSub(size, a, dp, -1, 0);
    }

    static int longestSub(int size, int[] a, int[][] dp, int prev, int index) {
        if (index == size)
            return 0; // Out of Elements so return the length as 0
        int notTake = longestSub(size, a, dp, prev, index + 1);
        if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];
        int take = 0;
        if (prev == -1 || a[index] > a[prev]) {
            take = 1 + longestSub(size, a, dp, index, index + 1);
        }
        return dp[index][prev + 1] = Math.max(notTake, take);
    }

    public static int lengthOfLIS(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                // as prev can start from i-1 as it is previous of current
                // element
                int inc = Integer.MIN_VALUE;
                if (prev == -1 || arr[i] > arr[prev])
                    inc = 1 + dp[i + 1][i + 1];
                int ign = dp[i + 1][prev + 1];
                dp[i][prev + 1] = Math.max(inc, ign);
            }
        }
        return dp[0][0];
    }

}
