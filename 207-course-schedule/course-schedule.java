import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] n : prerequisites){
            list.get(n[1]).add(n[0]);
        }
        int[] ind = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int nei : list.get(i)){
                ind[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int nei : list.get(node)){
                ind[nei]--;
                if(ind[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return count == numCourses;
    }
}