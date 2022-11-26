package DP.LCS;

import java.util.Arrays;

public class editDistanceGFGVARIANT {

    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return Solve(s, t, s.length(), t.length(), dp);
    }

    public int Solve(String s, String t, int index1, int index2, int[][] dp) {
        if (index1 == 0)
            return index2; // One Based Indexing Matrix is Created that's why.
        // it means the String is empty
        if (index2 == 0)
            return index1; // All Characters in a String is Matched.
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
            // Matched Characters
            return 0 + Solve(s, t, index1 - 1, index2 - 1, dp);
        }
        int insert = 1 + Solve(s, t, index1, index2 - 1, dp);
        int delete = 1 + Solve(s, t, index1 - 1, index2, dp);
        int replace = 1 + Solve(s, t, index1 - 1, index2 - 1, dp);
        return dp[index1][index2] = Math.min(replace, Math.min(delete, insert));
    }

    public static void main(String[] args) {

    }
}
