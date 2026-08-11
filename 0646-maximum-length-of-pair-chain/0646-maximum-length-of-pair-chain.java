 class Solution {

    int n;
    int[][] dp = new int[1001][1001];

    private int lis(int[][] pairs, int prevIdx, int currIdx) {

        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && dp[prevIdx][currIdx] != -1)
            return dp[prevIdx][currIdx];

        int taken = 0;

        if (prevIdx == -1 || pairs[currIdx][0] > pairs[prevIdx][1]) {
            taken = 1 + lis(pairs, currIdx, currIdx + 1);
        }

        int notTaken = lis(pairs, prevIdx, currIdx + 1);

        int result = Math.max(taken, notTaken);

        if (prevIdx != -1)
            dp[prevIdx][currIdx] = result;

        return result;
    }

    public int findLongestChain(int[][] pairs) {

        n = pairs.length;

        // Fill dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Sort pairs
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        return lis(pairs, -1, 0);
    }
}