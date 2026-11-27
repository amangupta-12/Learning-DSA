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
 class Pair{
    TreeNode node;
    int idx;
        
        Pair(TreeNode node , int idx){
            this.node = node;
            this.idx = idx;
        }
 }

class Solution {
    int max = 0;
    
    Pair lca(TreeNode root){
        if(root == null) return new Pair(null , 0);

        Pair l = lca(root.left);
        Pair r = lca(root.right);

        if(l.idx == r.idx){
            return new Pair(root , l.idx+1);
        }else if(l.idx > r.idx){
            return new Pair(l.node , l.idx+1);
        }else{
            return new Pair(r.node , r.idx+1);
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return lca(root).node;
    }
}