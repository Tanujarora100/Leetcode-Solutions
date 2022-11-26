package DP.LCS;

public class isSubsequenceLeetcode {

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n - tabulation(s, t, n, m) == 0)
            return true;
        else
            return false;
    }

    public static int tabulation(String A, String B, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
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

    }
}
