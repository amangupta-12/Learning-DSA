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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            int levelSum = 0;
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

                levelSum += (node.left != null) ? node.left.val : 0;
                levelSum += (node.right != null) ? node.right.val : 0;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            arr.add(levelSum);
        }

        q.add(root);
        int i = 0;
        while(!q.isEmpty()){
            int n = q.size();
             
            for(int j=0;j<n;j++){
                TreeNode node = q.poll();
                int siblingSum = 0;

                siblingSum += (node.left != null) ? node.left.val : 0;
                siblingSum += (node.right != null) ? node.right.val : 0;

                if(node.left != null) node.left.val = arr.get(i) - siblingSum;
                if(node.right != null) node.right.val  = arr.get(i) - siblingSum;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
            }
            i++;
        }
        root.val = 0;
        return root;
    }
}