class Solution {

    int n;
    int[][] dp = new int[1001][1001];

    private boolean predecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        if (M >= N || N - M != 1)
            return false;

        int i = 0;
        int j = 0;

        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == M;
    }

    private int lis(String[] words, int prevIdx, int currIdx) {

        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && dp[prevIdx][currIdx] != -1)
            return dp[prevIdx][currIdx];

        int taken = 0;

        if (prevIdx == -1 ||
            predecessor(words[prevIdx], words[currIdx])) {

            taken = 1 + lis(words, currIdx, currIdx + 1);
        }

        int notTaken = lis(words, prevIdx, currIdx + 1);

        int result = Math.max(taken, notTaken);

        if (prevIdx != -1)
            dp[prevIdx][currIdx] = result;

        return result;
    }

    public int longestStrChain(String[] words) {

        n = words.length;

        // Initialize DP with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Sort words by length
        Arrays.sort(words, (s1, s2) ->
            Integer.compare(s1.length(), s2.length())
        );

        return lis(words, -1, 0);
    }
}