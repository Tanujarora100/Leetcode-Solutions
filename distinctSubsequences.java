package DP.LCS;

import java.util.Arrays;

public class distinctSubsequences {
    int prime = (int) (Math.pow(10, 9) + 7);

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return Solve2(s, t, n, m, dp);
    }

    private int Solve2(String s1, String s2, int n, int m, int[][] dp) {
        if (m == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = Solve2(s1, s2, n - 1, m - 1, dp) + Solve2(s1, s2, n - 1, m, dp);
        } else
            return dp[n][m] = Solve2(s1, s2, n - 1, m, dp);
    }

    // int Solve(String s1, String s2, int ind1, int ind2, int[][] dp) {
    // if (ind2 < 0)
    // return 1;
    // if (ind1 < 0)
    // return 0;

    // if (dp[ind1][ind2] != -1)
    // return dp[ind1][ind2];

    // if (s1.charAt(ind1) == s2.charAt(ind2)) {
    // int leaveOne = Solve(s1, s2, ind1 - 1, ind2 - 1, dp);
    // int stay = Solve(s1, s2, ind1 - 1, ind2, dp);

    // return dp[ind1][ind2] = (leaveOne + stay) % prime;
    // }

    // else {
    // return dp[ind1][ind2] = Solve(s1, s2, ind1 - 1, ind2, dp);
    // }
    // }

    int tabulation(String s1, String s2, int ind1, int ind2) {
        int[][] dp = new int[ind1 + 1][ind2 + 1];
        for (int i = 0; i < ind1 + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < ind2 + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2] + dp[ind1 - 1][ind2 - 1];
                } else
                    dp[ind1][ind2] = dp[ind1 - 1][ind2];
            }
        }
        return dp[ind1][ind2];
    }

    public static void main(String args[]) {
        distinctSubsequences obj = new distinctSubsequences();
        System.out.println(obj.numDistinct("rabbbit", "rabbit"));
    }
}
