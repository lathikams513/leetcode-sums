class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        Integer[][][] dp = new Integer[m][n][3];

        return solve(0, 0, 0, coins, dp);
    }

    int solve(int i, int j, int k, int[][] coins, Integer[][][] dp) {
        int m = coins.length, n = coins[0].length;

        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && k < 2) {
                return Math.max(coins[i][j], 0); 
            }
            return coins[i][j];
        }

        if (dp[i][j][k] != null) return dp[i][j][k];

        int val = coins[i][j];

        int take = val + Math.max(
                solve(i + 1, j, k, coins, dp),
                solve(i, j + 1, k, coins, dp)
        );

        int skip = Integer.MIN_VALUE;
        if (val < 0 && k < 2) {
            skip = Math.max(
                    solve(i + 1, j, k + 1, coins, dp),
                    solve(i, j + 1, k + 1, coins, dp)
            );
        }

        return dp[i][j][k] = Math.max(take, skip);
    }
}