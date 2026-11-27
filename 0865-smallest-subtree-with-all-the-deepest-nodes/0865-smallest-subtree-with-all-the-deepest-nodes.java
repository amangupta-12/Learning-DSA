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
    int max = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    void depth(TreeNode root , int d){
        if(root == null) return;

        max = Math.max(max ,d);
        map.put(root.val , d);

        if(root.left != null){
            depth(root.left , d+1);
        }
        if(root.right != null){
            depth(root.right , d+1);
        }
    }

    TreeNode lca(TreeNode root){
        if(root == null) return null;
        if(map.get(root.val) != null && map.get(root.val) == max){
            return root;
        }
        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);

        if(left != null && right != null) return root;
        else if(left != null) return left;

        return right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
        return lca(root);
    }
}