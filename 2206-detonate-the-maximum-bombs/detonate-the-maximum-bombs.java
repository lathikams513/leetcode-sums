class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> g = new ArrayList<>();

        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) continue;

                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r  = bombs[i][2];

                if(dx*dx + dy*dy <= r*r){
                    g.get(i).add(j);
                }
            }
        }

        int max = 0;

        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[n];
            max = Math.max(max, dfs(i, g, visited));
        }

        return max;
    }

    int dfs(int node, List<List<Integer>> g, boolean[] visited){
        visited[node] = true;
        int count = 1;

        for(int nei : g.get(node)){
            if(!visited[nei]){
                count += dfs(nei, g, visited);
            }
        }
        return count;
    }
}