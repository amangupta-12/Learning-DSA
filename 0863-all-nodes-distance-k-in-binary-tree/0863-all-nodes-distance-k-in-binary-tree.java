/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void findParent(TreeNode root , HashMap<TreeNode,TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                    map.put(node.left , node);
                }
                if(node.right != null){
                    q.add(node.right);
                    map.put(node.right, node);
                }
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       HashMap<TreeNode,TreeNode> map = new HashMap<>();
       findParent(root,map);
       Queue<TreeNode> q = new LinkedList<>();
       HashMap<Integer,Boolean> vis = new HashMap<>();
       q.add(target);
       vis.put(target.val , true);
       int len = 0;
       while(!q.isEmpty()){
        int size = q.size();
        if(len == k) break;
        len++;
        for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            if(node.left != null && (!vis.containsKey(node.left.val))){
                vis.put(node.left.val,true);
                q.add(node.left);
            }
            if(node.right != null && (!vis.containsKey(node.right.val))){
                vis.put(node.right.val,true);
                q.add(node.right);
            }
            if(map.containsKey(node) && (!vis.containsKey(map.get(node).val))){
                vis.put(map.get(node).val,true);
                q.add(map.get(node));
            }
        }

       }
       List<Integer> result = new ArrayList<>();
       while(!q.isEmpty()){
        result.add(q.poll().val);
       }

       return result;

    }
}