class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        BackTrack(res,"",0,0,n);
        return res;
        
    }
    public void BackTrack(List<String> res,String s,int oc,int cc,int n){
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        if(oc<n){
            BackTrack(res,s+"(",oc+1,cc,n);

        }
        if(cc<oc){
            BackTrack(res,s+")",oc,cc+1,n);

        }
    }
}