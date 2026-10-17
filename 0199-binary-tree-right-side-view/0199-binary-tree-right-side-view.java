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
    List<Integer> res = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();

    void solve(TreeNode root , int row){
        if(root == null) return;
        if(!map.containsKey(row)){
            map.put(row , root.val);
            res.add(root.val);
        }
       
        if(root.right != null){
            solve(root.right , row+1);
        }   if(root.left != null){
            solve(root.left , row+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        solve(root , 0);
        return res;
    }
}