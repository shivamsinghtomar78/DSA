class Solution {
    public int longestSubarray(int[] nums) {

        int zeroCount = 0;
        int longestWindow = 0;

        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            // Shrink the window until there is at most one zero
            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            // Delete one element, so window length is (j - i)
            longestWindow = Math.max(longestWindow, j - i);
        }

        return longestWindow;
    }
}