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
    List<Integer> rev(List<Integer> list){
        int i = 0;
        int j = list.size()-1;
        while( i < j){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        return list;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        boolean button = true;
        if(root == null){
            return ans;
        }else{
    ans.add(new ArrayList<>(Arrays.asList(root.val)));        }
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                 TreeNode node = q.poll();
                if(node != null){
                    if(node.left != null && node.right != null){
                        list.add(node.left.val);
                        list.add(node.right.val);
                        q.add(node.left);
                        q.add(node.right);
                    }else if(node.left != null){
                        list.add(node.left.val);
                        q.add(node.left);
                     }else if(node.right != null){
                        list.add(node.right.val);
                        q.add(node.right);
                     }
                }
            }
            if(list.size() > 0){
            if(!button){
                ans.add(list);
            }else{
                ans.add(rev(list));
            }
             button = !button;
            }
        }
        return ans;
    }
}