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
   
    public boolean isCousins(TreeNode root, int x, int y) {
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);

      int child = 0;
      int parent = 0;

      while(!q.isEmpty()){
        int size = q.size();
        child = 0;

        for(int i=0;i<size;i++){
        TreeNode node =  q.poll();
            parent = 0;
            
            if(node.left != null && (node.left.val == x || node.left.val == y)){
                child++;
                parent++;
            } 
            if(node.right != null && (node.right.val == x || node.right.val == y)){
                child++;
                parent++;
            }
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);


            if(parent == 2) return false;

        }
        if(child == 2) return true;
      }
        return false;
    }
}