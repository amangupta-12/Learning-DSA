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
    HashSet<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    TreeNode solve(TreeNode root , int[] del){
        if(root == null) return null;
        
        if(set.contains(root.val)){
            if(root.left != null) list.add(solve(root.left , del));
            if(root.right != null) list.add(solve(root.right,del));
            return null;
        }
            root.left = solve(root.left , del);
            root.right = solve(root.right , del);

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }

        list.add(solve(root,to_delete));
        list.removeIf(node -> node == null);

        return list;
    }
}