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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

               int left = (node.left != null) ? node.left.val : -101;
               int right = (node.right != null) ? node.right.val : -101;

                level.add(left);
                level.add(right);

                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            List<Integer> reversed =  new ArrayList<>(level);
            Collections.reverse(reversed);
            if(!(reversed.equals(level))){
                return false;
            }
        }
        return true;
    }
}