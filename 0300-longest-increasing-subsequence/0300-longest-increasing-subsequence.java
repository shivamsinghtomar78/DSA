class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, nums, dp);
    }

    private int solve(int i, int prev, int[] nums, int[][] dp) {
        if (i == nums.length)
            return 0;

        // Store prev = -1 at index 0, prev = 0 at index 1, etc.
        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve(i + 1, i, nums, dp);
        }

        int skip = solve(i + 1, prev, nums, dp);

        return dp[i][prev + 1] = Math.max(take, skip);
    }
}