package DP.LCS;

public class printLCS {
    public static StringBuilder Printing(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder result = new StringBuilder();
        int[][] dp = new int[n + 1][m + 1];
        Solve(result, b, n, m, dp);
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                result.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return result.reverse();
    }

    public static int Solve(StringBuilder result, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (result.charAt(n - 1) == b.charAt(m - 1))
            return dp[n][m] = 1 + Solve(result, b, n - 1, m - 1, dp);
        else
            return dp[n][m] = 0 + Math.max(Solve(result, b, n - 1, m, dp), Solve(result, b, n, m - 1, dp));
    }

    public static void main(String[] args) {
        String A = "bebdeeedaddecebbbbbabebedc";
        String B = "abaaddaabbedeedeacbcdcaaed";
        System.out.println(Printing(A, B));
    }
}
