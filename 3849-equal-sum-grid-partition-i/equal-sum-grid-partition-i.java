class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long totalSum = 0;

        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        if (totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        long sum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            if (sum == target) return true;
        }

        sum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }
            if (sum == target) return true;
        }

        return false;
    }
}