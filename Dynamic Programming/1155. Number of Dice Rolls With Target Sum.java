class Solution {
    int mod = 1000_000_007;
    int[][] dp;
    
    public int numRollsToTarget(int n, int k, int target) {
        // if(target > n*k) return 0; // another important base case to consider before moving forward 
        dp = new int[n + 1][target + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return helper(n, k, target);
    }
    
    private int helper(int n, int k, int target)
    {
        if(target == 0 && n == 0) return 1;
        if(target == 0 || n == 0) return 0;
        
        if(dp[n][target] != -1) return dp[n][target];
        
        int ans = 0;
        for(int i = 1; i <= k; i++)
        {
            int x = target;
            if(x - i >= 0)
                ans = (ans + helper(n - 1, k, x - i)) % mod;
            else // early pruning
                break;
        }
        
        dp[n][target] = ans;
        return dp[n][target];
    }
}
