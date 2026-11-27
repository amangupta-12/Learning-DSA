class Solution {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    void solve(TreeNode root) {
        if (root == null) return;

        int len = sb.length();

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        } else {
            sb.append("->");
            solve(root.left);
            solve(root.right);
        }

        sb.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        solve(root);
        return list;
    }
}