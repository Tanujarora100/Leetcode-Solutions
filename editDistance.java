package DP.LCS;

import java.util.Arrays;

public class editDistance {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return Solve(word1, word2, n - 1, m - 1, dp);
    }

    private int Solve(String word1, String word2, int n, int m, int[][] dp) {
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (word1.charAt(n) == word2.charAt(m)) {
            return 0 + Solve(word1, word2, n - 1, m - 1, dp);
        }
        int insert = 1 + Solve(word1, word2, n, m - 1, dp);
        int delete = 1 + Solve(word1, word2, n - 1, m, dp);
        int replace = 1 + Solve(word1, word2, n - 1, m - 1, dp);
        return dp[n][m] = Math.min(insert, Math.min(delete, replace));
    }

    public int count(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                }
                int insert = dp[i][j - 1];
                int delete = dp[i - 1][j];
                int replace = dp[i - 1][j - 1];
                dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
