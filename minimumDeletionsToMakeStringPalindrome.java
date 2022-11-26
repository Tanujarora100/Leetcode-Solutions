package DP.LCS;

import java.util.Arrays;

public class minimumDeletionsToMakeStringPalindrome {

    static int minimumNumberOfDeletions(String S) {

        StringBuilder input1 = new StringBuilder();
        // append a string into StringBuilder input1
        input1.append(S);
        StringBuilder b = input1.reverse();
        String c = b.toString();
        int m = c.length();
        // Same just reverse the string as the Subsequences always have the correct
        // order
        /*
         * if there is a subsequence which is common it must be
         * a palindrome coz if not then order will be different and it will not be
         * evaluated by the program.
         */
        int n = S.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int lps = Solve(S, c, n, m, dp);
        return n - lps;
    }

    private static int Solve(String s, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (s.charAt(n - 1) == b.charAt(m - 1))
            return dp[n][m] = 1 + Solve(s, b, n - 1, m - 1, dp);
        else
            return dp[n][m] = 0 + Math.max(Solve(s, b, n - 1, m, dp), Solve(s, b, n, m - 1, dp));
    }

    public static void main(String[] args) {

    }
}
