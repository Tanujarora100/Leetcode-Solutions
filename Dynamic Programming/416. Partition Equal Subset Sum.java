 public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1)
            return false;
        else {
            int target = sum / 2;
            int n = nums.length;
            int[][] dp = new int[n + 1][target + 1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return Solve(n - 1, target, nums, dp);
        }
    }

    public static boolean Solve(int n, int target, int[] arr, int[][] dp) {

        if (target == 0)
            return true;
        if (n == 0)
            return arr[0] == target;
        if (dp[n][target] != -1)
            return dp[n][target] == 0 ? false : true;

        boolean notpick = Solve(n - 1, target, arr, dp);
        boolean pick = false;
        if (arr[n] <= target) {
            pick = Solve(n - 1, target - arr[n], arr, dp);
        }
        dp[n][target] = pick || notpick ? 1 : 0;
        return pick || notpick;
    }
