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

    TreeNode solve(int[] postorder , int postStart , int postEnd ,int[] inorder, int inStart , int inEnd , HashMap<Integer,Integer> map){ 
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);

        int numLeft = inRoot - inStart;
        int numRight = inEnd - inRoot;

    root.left = solve(postorder,postStart,postStart+numLeft-1,inorder,inStart , inStart + numLeft , map);
    root.right = solve(postorder,postStart+numLeft,postEnd-1,inorder,inStart + numLeft+1, inEnd, map);
    return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return solve(postorder , 0 , postorder.length-1 , inorder , 0 ,inorder.length-1 , map);
    }
}