   static int lcs(String X, String Y, int i, int j, int count) {
        if (i == 0 || j == 0) {
            return count;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            count = lcs(X, Y, i - 1, j - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcs(X, Y, i, j - 1, 0), lcs(X, Y, i - 1, j, 0)));
        return count;
    }

    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
