// class Solution {

//     private int solve(int x, int y, int m, int n, int[][] dp) {
//         if (x == m - 1 && y == n - 1) {
//             return 1;
//         }
//         if (dp[x][y] != -1)
//             return dp[x][y];
//         int path1 = 0, path2 = 0;
//         if (x >= 0 && x < m && y >= 0 && y < n) {
//             path1 = solve(x + 1, y, m, n, dp);
//             path2 = solve(x, y + 1, m, n, dp);
//         }
//         return dp[x][y] = path1 + path2;
//     }

//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m + 1][n + 1];
//         for (int[] put : dp) {
//             Arrays.fill(put, -1);
//         }
//         return solve(0, 0, m, n, dp);
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
            }else{   
                int path1 = 0, path2 = 0;
                if (i > 0)
                    path1 = dp[i - 1][j];
                if (j > 0)
                    path2 = dp[i][j - 1];
                dp[i][j] = path1 + path2;
            }
        }
        }
        return dp[m-1][n-1];
    }
}