class Solution {
    public String makeGood(String s) {
        if(s.length()==1 || s.length()==0){
            return s;
        }
        Stack<Character> stk=new Stack<>();

        for(char c:s.toCharArray()){
            if(!stk.isEmpty() && Math.abs(stk.peek()-c)==32){
                stk.pop();

            }
            else{
                stk.push(c);
            }
        }

        StringBuilder sb=new StringBuilder();

        for(char c:stk){
            sb.append(c);
        }
        return sb.toString();
    }
}