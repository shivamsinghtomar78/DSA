class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n][2];

        // dp[i][0] = maximum alternating sum ending with a subtraction
        // dp[i][1] = maximum alternating sum ending with an addition

        dp[0][0] = Math.max(-1L * nums[0], 0L);
        dp[0][1] = Math.max((long) nums[0], 0L);

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][1] - nums[i], dp[i - 1][0]);

            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}