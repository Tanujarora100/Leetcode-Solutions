package DP.LCS;

public class palindromicSubstrings {
    public int countSubstrings(String s) {
        StringBuilder b = new StringBuilder();
        int n = s.length();
        String c = b.append(s).reverse().toString();
        return longestCommonSubstr(s, c, n, n);
    }

    static int longestCommonSubstr(String S1, String S2, int n, int m) {
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
                    ans++;
                }
                dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
