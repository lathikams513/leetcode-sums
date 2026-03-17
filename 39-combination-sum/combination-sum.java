class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(candidates,target,result,temp,0);
        return result;
    }
    public void backtrack(int[] candidates, int target,List<List<Integer>> result,List<Integer> temp,int start){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            target=target-candidates[i];
            backtrack(candidates,target,result,temp,i);
            target=target+candidates[i];
            temp.remove(temp.size()-1);        
            }
    }
}