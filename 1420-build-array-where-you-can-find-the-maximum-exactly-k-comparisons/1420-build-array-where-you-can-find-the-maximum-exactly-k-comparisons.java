class Solution {

    int N, M, K;
    int MOD = 1_000_000_007;

    int[][][] dp = new int[51][51][101];

    private int solve(int idx, int searchCost, int maxSoFar) {

        if (idx == N) {
            if (searchCost == K)
                return 1;

            return 0;
        }

        if (dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }

        int result = 0;

        for (int i = 1; i <= M; i++) {

            if (i > maxSoFar) {
                result = (result
                        + solve(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result
                        + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }

        return dp[idx][searchCost][maxSoFar] = result;
    }

    public int numOfArrays(int n, int m, int k) {

        N = n;
        M = m;
        K = k;

        // Equivalent to memset(dp, -1, sizeof(dp))
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0);
    }
}