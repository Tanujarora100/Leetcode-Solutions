 public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][3][4];
        for (int[][] row : dp) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        return Solve(prices, 0, 1, dp, 2);
    }

    public static int Solve(int[] arr, int n, int buy, int[][][] dp, int count) {
        if (n >= arr.length)
            return 0;
        if (count == 0)
            return 0;
        int maxProfit = 0;
        if (dp[n][buy][count] != -1)
            return dp[n][buy][count];
        if (buy == 1) {
            maxProfit = Math.max(-arr[n] + Solve(arr, n + 1, 0, dp, count), 0 + Solve(arr, n + 1, 1, dp, count));
        }
        // Writing Selling Case here.
        else {
            maxProfit = Math.max(arr[n] + Solve(arr, n + 1, 1, dp, count - 1),
                    0 + Solve(arr, n + 1, 0, dp, count));
        }
        return dp[n][buy][count] = maxProfit;
    }

    public int maxProfitSpaceOptimized(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
                t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
                t2Profit = 0;

        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // reinvest the gained profit in the second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }
