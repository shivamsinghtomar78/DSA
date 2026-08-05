class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp = new int[n + 1];

        int result1;
        int result2;

        // Case 1: Rob houses from 0 to n-2 (skip last house)
        dp[0] = 0;
        for (int i = 1; i <= n - 1; i++) {
            dp[i] = Math.max(dp[i - 1],
                    nums[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0));
        }
        result1 = dp[n - 1];

        // Case 2: Rob houses from 1 to n-1 (skip first house)
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    nums[i - 1] + dp[i - 2]);
        }
        result2 = dp[n];

        return Math.max(result1, result2);
    }
}