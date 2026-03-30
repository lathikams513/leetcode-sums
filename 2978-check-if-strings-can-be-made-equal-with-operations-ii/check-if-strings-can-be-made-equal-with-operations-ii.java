class Solution {
    public boolean checkStrings(String s1, String s2) {
        Map<Character,Integer> even=new HashMap<>();
        Map<Character,Integer> odd=new HashMap<>();

        int n=s1.length();

        for(int i=0;i<n;i++){
            char ch=s1.charAt(i);
            if(i%2==0){
                even.put(ch,even.getOrDefault(ch,0)+1);
            }
            else{
                odd.put(ch,odd.getOrDefault(ch,0)+1);

            }
        }

        for(int i=0;i<n;i++){
            char ch=s2.charAt(i);
            if(i%2==0){
                even.put(ch,even.getOrDefault(ch,0)-1);
            }
            else{
                odd.put(ch,odd.getOrDefault(ch,0)-1);

            }
        }

        for(int val:even.values()){
            if(val!=0) return false;
        }

         for(int val:odd.values()){
            if(val!=0) return false;
        }

        return true;



        
    }
}