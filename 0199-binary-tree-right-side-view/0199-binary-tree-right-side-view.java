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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        if(root == null) return res;
        res.add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node != null){
                  if(node.left != null && node.right != null){
                    temp.add(node.left.val);
                    temp.add(node.right.val);
                    q.add(node.left);
                    q.add(node.right);
                  }else if(node.left != null){
                     temp.add(node.left.val);
                    q.add(node.left);
                    }else if(node.right != null){
                     temp.add(node.right.val);
                    q.add(node.right);
                    }
                  }
                }
                if(temp.size() > 0){
                res.add(temp.get(temp.size()-1));
                }
            }

            return res;
        }
}
       