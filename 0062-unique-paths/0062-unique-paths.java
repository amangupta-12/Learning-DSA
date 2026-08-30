class Solution {

    private int solve(int x, int y, int m, int n, int[][] dp) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1)
            return dp[x][y];
        int path1 = 0, path2 = 0;
        if (x >= 0 && x < m && y >= 0 && y < n) {
            path1 = solve(x + 1, y, m, n, dp);
            path2 = solve(x, y + 1, m, n, dp);
        }
        return dp[x][y] = path1 + path2;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] put : dp) {
            Arrays.fill(put, -1);
        }
        return solve(0, 0, m, n, dp);
    }
}