class Solution {
    public boolean areSimilar(int[][] mat, int k) {
         int n=mat.length;
         int m=mat[0].length;
         int[][] mat1=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(i%2==0){
                    mat1[i][j]=mat[i][(j+k)%m];
                 }
                 else{
                    mat1[i][j]=mat[i][(j-k % m+m)% m];
                 }
            }
         }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=mat1[i][j]){
                    return false;
                }
            }
         }
        return true;
    }
}