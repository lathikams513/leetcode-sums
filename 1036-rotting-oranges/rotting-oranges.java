class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int minutes = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();

                for (int k = 0; k < 4; k++) {
                    int r = cell[0] + dr[k];
                    int c = cell[1] + dc[k];

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}