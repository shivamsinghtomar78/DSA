class Solution {
    int[] dp = new int[101];

    private int solve(int[] nums, int i, int n) {
        if (i > n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // Rob current house and move to i + 2
        int take = nums[i] + solve(nums, i + 2, n);

        // Skip current house and move to i + 1
        int skip = solve(nums, i + 1, n);

        return dp[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Case 1: Consider houses from 0 to n-2
        Arrays.fill(dp, -1);
        int take0thHouse = solve(nums, 0, n - 2);

        // Case 2: Consider houses from 1 to n-1
        Arrays.fill(dp, -1);
        int take1stHouse = solve(nums, 1, n - 1);

        return Math.max(take0thHouse, take1stHouse);
    }
}