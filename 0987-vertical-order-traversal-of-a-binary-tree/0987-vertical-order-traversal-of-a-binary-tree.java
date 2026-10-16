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
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    List<List<Integer>> res = new ArrayList<>();

    void solve(int col, TreeNode root, int level) {
        if(root == null) return;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(level, new PriorityQueue<>());

            map.get(col).get(level).offer(root.val);
    
        if (root.left != null) {
            solve(col - 1, root.left, level + 1);
        }
        if (root.right != null) {
            solve(col + 1, root.right, level + 1);
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null)
            return res;
        solve(0, root, 1);

        for (TreeMap<Integer , PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> ans = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    ans.add(pq.poll());
                }
              
        }
            res.add(ans);
        }

        return res;
    }
}