/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        backtrack(root,result,0);
        return result;
    }
    public void backtrack(TreeNode root,List<Integer> result,int level){
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(root.val);
        }
        
        backtrack(root.right,result,level+1);
         backtrack(root.left,result,level+1);
    }
}