class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        // dp[i] = maximum profit till house i
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {

            int skip = dp[i - 1];
            int steal = nums[i - 1] + dp[i - 2];

            // Maximum profit till current house
            dp[i] = Math.max(skip, steal);

            /*
             * SKIP  : If we skip this house,
             *         profit = dp[i - 1]
             *
             * STEAL : If we rob this house,
             *         profit = nums[i - 1] + dp[i - 2]
             */
        }

        return dp[n];
    }
}