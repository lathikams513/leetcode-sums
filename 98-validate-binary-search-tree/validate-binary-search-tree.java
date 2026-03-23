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
    List<Integer> list = new ArrayList<>();

    public void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root);

        for(int i = 1; i < list.size(); i++){
            if(list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
}

    // public boolean isValid(TreeNode root,long min,long max){
    //     if(root==null) return true;
    //     if(root.val<=min || root.val>=max) return false;
    //     return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);

    // }
//     public boolean isValidBST(TreeNode root) {
//         // return isValid(root ,Long.MIN_VALUE,Long.MAX_VALUE);
//         inOrder(root);


//     }
// }