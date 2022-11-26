package DP.LCS;

public class lcsTabulation {

    int getLengthOfLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return Solve(s1, s2, n, m);
    }

    private int Solve(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "workattech";
        String s2 = "branch";
        lcsTabulation obj = new lcsTabulation();
        System.out.println(obj.getLengthOfLCS(s1, s2));
    }
}
