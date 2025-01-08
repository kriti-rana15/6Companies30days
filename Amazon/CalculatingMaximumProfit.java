class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // DP table
        int[][] dp = new int[n + 1][2 * k + 1];

        // Base cases: dp[n][...] = 0, as there are no profits after the last day
        for (int j = 0; j <= 2 * k; j++) {
            dp[n][j] = 0;
        }

        // Fill the table from the bottom
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2 * k; j++) {
                if (j % 2 == 0) {
                    // Buy case
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);
                } else {
                    // Sell case
                    dp[i][j] = Math.max(prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}