import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;

        // use LONG map (important fix)
        Map<Long, Integer> right = new HashMap<>();
        for (int[] row : grid) {
            for (int val : row) {
                long v = val;
                total += v;
                right.put(v, right.getOrDefault(v, 0) + 1);
            }
        }

        Map<Long, Integer> left = new HashMap<>();

        // 🔹 Horizontal cuts
        long topSum = 0;
        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                topSum += val;

                // move element
                left.put(val, left.getOrDefault(val, 0) + 1);
                right.put(val, right.get(val) - 1);
                if (right.get(val) == 0) right.remove(val);
            }

            long bottomSum = total - topSum;

            if (check(grid, left, right,
                      topSum, bottomSum,
                      0, i, 0, n - 1,
                      i + 1, m - 1, 0, n - 1)) {
                return true;
            }
        }

        // 🔹 Reset maps
        right.clear();
        left.clear();

        for (int[] row : grid) {
            for (int val : row) {
                long v = val;
                right.put(v, right.getOrDefault(v, 0) + 1);
            }
        }

        // 🔹 Vertical cuts
        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) {

            for (int i = 0; i < m; i++) {
                long val = grid[i][j];
                leftSum += val;

                left.put(val, left.getOrDefault(val, 0) + 1);
                right.put(val, right.get(val) - 1);
                if (right.get(val) == 0) right.remove(val);
            }

            long rightSum = total - leftSum;

            if (check(grid, left, right,
                      leftSum, rightSum,
                      0, m - 1, 0, j,
                      0, m - 1, j + 1, n - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean check(int[][] grid,
                          Map<Long, Integer> A,
                          Map<Long, Integer> B,
                          long sumA, long sumB,
                          int rs1, int re1, int cs1, int ce1,
                          int rs2, int re2, int cs2, int ce2) {

        if (sumA == sumB) return true;

        long diff = Math.abs(sumA - sumB);

        if (sumA > sumB) {
            return canRemove(grid, A, diff, rs1, re1, cs1, ce1);
        } else {
            return canRemove(grid, B, diff, rs2, re2, cs2, ce2);
        }
    }

    private boolean canRemove(int[][] grid,
                              Map<Long, Integer> map,
                              long target,
                              int rs, int re, int cs, int ce) {

        // diff must exist as a single cell
        if (!map.containsKey(target)) return false;

        int rows = re - rs + 1;
        int cols = ce - cs + 1;

        // only one cell → cannot remove
        if (rows * cols == 1) return false;

        // single row → only ends allowed
        if (rows == 1) {
            return grid[rs][cs] == target || grid[rs][ce] == target;
        }

        // single column → only ends allowed
        if (cols == 1) {
            return grid[rs][cs] == target || grid[re][cs] == target;
        }

        // proper 2D grid → any cell works
        return true;
    }
}