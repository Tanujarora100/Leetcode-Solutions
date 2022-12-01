package DP.LCS;

import java.util.Arrays;

public class countPalindromeSubsequence {
    long countPS(String str) {
        StringBuilder s1 = new StringBuilder();
        int n = str.length();
        int m = s1.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Solve(str, s1.append(str).reverse().toString(), n - 1, m - 1, dp);

    }

    private long Solve(String str, String str2, int n, int m, int[][] dp) {
        if (n < 0 || m < 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (str.charAt(n) == str2.charAt(m))
            return dp[n][m] = (int) (1 + Solve(str, str2, n - 1, m - 1, dp));
        else
            return dp[n][m] = (int) ((int) Solve(str, str2, n - 1, m, dp) + Solve(str, str2, n, m - 1, dp));
    }

    public static void main(String[] args) {
        countPalindromeSubsequence obj = new countPalindromeSubsequence();
        System.out.println(obj.countPS("abcd"));
    }
}
