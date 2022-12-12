package DP.DayFour;

public class paintFence {
    /*
     * Recurrence formula: for a given number of posts (i>=3)
     * 
     * dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1);
     * 
     * The reason is that for a given i, we can consider both i itself and [i-1,i]
     * as a whole, for the former case, we have k-1 choice, for the later case, we
     * also have k-1 choice.
     * 
     * Initial case: n <=2 return k^n
     * 
     * e.g: for n = 3, k =3
     * We can consider 3rd post itself, so it has 2 choice. And we also can consider
     * 2nd & 3rd posts as a whole, it has 2 choice too.
     * The total choice: 9 * 2 + 3 * 2 = 24
     * 
     * 
     */
    public int numWays(int n, int k) {
        if (n == 1)
            return k;

        int twoPostsBack = k;
        int onePostBack = k * k;

        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (onePostBack + twoPostsBack);
            twoPostsBack = onePostBack;
            onePostBack = curr;
        }

        return onePostBack;
    }

    public int numWaysTab(int n, int k) {
        // Base cases for the problem to avoid index out of bound issues
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        int totalWays[] = new int[n + 1];
        totalWays[1] = k;
        totalWays[2] = k * k;

        for (int i = 3; i <= n; i++) {
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }

        return totalWays[n];
    }

    // memoization DP
    int totalWaysMemo(int n, int k, int[] memo) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        if (memo[n] != 0)
            return memo[n];

        memo[n] = (k - 1) * (totalWaysMemo(n - 1, k, memo) + totalWaysMemo(n - 2, k, memo));
        return memo[n];
    }

}
