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
    int solve(TreeNode root , int[] max){
        if(root == null) return 0;

        int left = solve(root.left ,max);
        int right = solve(root.right ,max);

        max[0] = Math.max( left + right , max[0]) ;
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        solve(root,max);
        return max[0];
    }
}