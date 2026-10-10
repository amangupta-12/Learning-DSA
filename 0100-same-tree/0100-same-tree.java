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
    boolean solve(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        boolean left = false;
        boolean right = false;

        if (p.val != q.val)
            return false;
        left = solve(p.left, q.left);
        right = solve(p.right, q.right);
        return left && right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
}