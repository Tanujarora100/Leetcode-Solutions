package DP.LCS;

import java.util.Arrays;

public class shortestCommonSuperSequence {
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int len = X.length() + Y.length(); // Merged Length lo and usme se LCS ko Ghata do to Yeh aajayega.
        return len - Solve(X, Y, m, n, dp);
    }

    private static int Solve(String x, String y, int m, int n, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (x.charAt(m - 1) == y.charAt(n - 1))
            return dp[m][n] = 1 + Solve(x, y, m - 1, n - 1, dp);
        return dp[m][n] = Math.max(Solve(x, y, m - 1, n, dp), Solve(x, y, m, n - 1, dp));
    }

    public static void main(String[] args) {

    }
}
