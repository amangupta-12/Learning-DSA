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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        q.add(root);
     ans.add(new ArrayList<>(List.of(root.val)));
        int alt = 0;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    list.add(node.left.val);
                    q.add(node.left);
                }
                if(node.right != null){
                    list.add(node.right.val);
                    q.add(node.right);
                }
            }
            if(list.size()>0){
            if(alt == 1){
                alt = 0;
                ans.add(list);
            }else{
                alt = 1;
                List<Integer> rev = new ArrayList<>(list);
                Collections.reverse(rev);
                ans.add(rev);
            }
        }
        }
        return ans;
    }
}