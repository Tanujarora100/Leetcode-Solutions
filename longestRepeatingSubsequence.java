package DP.LCS;

import java.util.Arrays;

public class longestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String str) {
        String a = str;
        String b = str;
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return Solve(a, b, n, m, dp);
    }

    private int Solve(String a, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (a.charAt(n - 1) == b.charAt(m - 1) && n != m) {
            return dp[n][m] = 1 + Solve(a, b, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(Solve(a, b, n - 1, m, dp), Solve(a, b, n, m - 1, dp));
        }
    }

    public static int tabulation(String A, String B, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
