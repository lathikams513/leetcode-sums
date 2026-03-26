class Solution {
    public void dfs(int room,List<List<Integer>> rooms,boolean[] visited){
        visited[room]=true;

        for(int s:rooms.get(room)){
            if(!visited[s]){
                dfs(s,rooms,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];

        dfs(0,rooms,visited);

        for(boolean v:visited){
            if(!v){
                return false;
            }       
        
    }
    return true;
}
}