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
 *         this.l dueft = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    long idx;

    Pair(TreeNode node , long idx){
        this.node = node;
        this.idx = idx;
    }
 }
class Solution {
   
    public int widthOfBinaryTree(TreeNode root) {
       Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root , 0));

        long max = 0;
        while(!q.isEmpty()){
            
            long l = q.getFirst().idx;
            long r = q.getLast().idx;

            max = Math.max(max , r-l+1);

            int n = q.size();

            while(n-- >0){
              Pair pair = q.poll();
              TreeNode roott = pair.node;
              long index = pair.idx;

                if(roott.left != null){
                    q.add(new Pair(roott.left , 2*index+1));
                }
                if(roott.right != null){
                    q.add(new Pair(roott.right , 2*index+2));
                }

            }
        }

        return (int) max;
    }
}