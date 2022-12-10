 public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][3][101];
        for (int[][] row : dp) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        return Solve(prices, 0, 1, dp, k, 0);
    }

    public static int Solve(int[] arr, int n, int buy, int[][][] dp, int k, int count) {
        if (n >= arr.length)
            return 0;
        if (count == k)
            return 0;
        int maxProfit = 0;
        if (dp[n][buy][count] != -1)
            return dp[n][buy][count];
        if (buy == 1) {
            maxProfit = Math.max(-arr[n] + Solve(arr, n + 1, 0, dp, k, count), 0 + Solve(arr, n + 1, 1, dp, k, count));
        }
        // Writing Selling Case here.
        else {
            maxProfit = Math.max(arr[n] + Solve(arr, n + 1, 1, dp, k, count + 1),
                    0 + Solve(arr, n + 1, 0, dp, k, count));
        }
        return dp[n][buy][count] = maxProfit;
    }

    public int maxProfitSpaceOptimized(int k, int[] prices) {
        if (k == 0)
            return 0;

        int[] profit = new int[k + 1];
        int[] cost = new int[k + 1];

        profit[0] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                cost[i + 1] = Math.min(cost[i + 1], price - profit[i]);
                profit[i + 1] = Math.max(profit[i + 1], price - cost[i + 1]);
            }
        }
        return profit[k];
    }
