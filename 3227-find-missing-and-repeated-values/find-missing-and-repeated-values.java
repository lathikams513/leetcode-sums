import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        Set<Integer> set = new HashSet<>();

        int repeat = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (set.contains(grid[i][j])) {
                    repeat = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        int missing = -1;
        for (int i = 1; i <= n * n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeat, missing};
    }
}