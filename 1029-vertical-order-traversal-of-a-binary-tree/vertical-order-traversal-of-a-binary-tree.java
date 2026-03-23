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

    class Pair {
        TreeNode node;
        int col, row;

        Pair(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            TreeNode node = curr.node;
            int col = curr.col;
            int row = curr.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1, row + 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (List<Integer> nodes : rows.values()) {
                Collections.sort(nodes); 
                list.addAll(nodes);
            }

            result.add(list);
        }

        return result;
    }
}