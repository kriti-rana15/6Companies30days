class Solution {
    static final int MOD = 1000000007;
    public int solve(int startPos, int endPos, int k, int[][] dp) {
        if (k < 0) return 0;
        int ans = 0;
        if (k == 0) {
            if (startPos == endPos) return 1;
            return 0;
        }
        if (dp[startPos + 1000][k] != -1) return dp[startPos + 1000][k];
        ans = (ans + solve(startPos - 1, endPos, k - 1, dp)) % MOD;
        ans = (ans + solve(startPos + 1, endPos, k - 1, dp)) % MOD;
        dp[startPos + 1000][k] = ans % MOD;
        return ans;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[7001][k + 1];
        for (int i = 0; i < 7001; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }   
        return solve(startPos, endPos, k, dp);
    }
}