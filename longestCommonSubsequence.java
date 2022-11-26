package DP.LCS;

import java.util.Arrays;

public class longestCommonSubsequence {

    public static int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Solve2(A, B, n - 1, m - 1, dp);
    }

    // Making it 1 Based Indexing just make a matrix of N+1 and M+1 and If make Base
    // case==0
    // Otherwise make it less than Zero.
    public static int Solve2(String A, String B, int n, int m, int[][] dp) {
        if (n < 0 || m < 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (A.charAt(n) == B.charAt(m))
            return dp[n][m] = 1 + Solve2(A, B, n - 1, m - 1, dp);
        else
            return dp[n][m] = Math.max(Solve2(A, B, n - 1, m, dp), Solve2(A, B, n, m - 1, dp));
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
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String A = "bebdeeedaddecebbbbbabebedc";
        String B = "abaaddaabbedeedeacbcdcaaed";
        System.out.println(solve(A, B));
    }

}
