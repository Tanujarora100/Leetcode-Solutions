package DP.LCS;

public class longestSubstring {
    static int recursive(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0)
            return count;
        if (s1.charAt(n - 1) == s2.charAt(n - 2)) {
            count = recursive(s1, s2, n - 1, m - 1, count + 1);
        } else {
            count = recursive(s1, s2, n - 1, m, 0) + recursive(s1, s2, n, m - 1, 0);
        }
        return count;
    }

    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val);
                }
                dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
