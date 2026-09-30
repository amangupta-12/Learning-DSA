class Solution {

    // int solve(int i, int j, int[][] mat,int[][] dp) {
    //     if (j < 0 || j >= mat[0].length)
    //         return 1000000009;

    //     if (i == 0)
    //         return dp[i][j] = mat[i][j];
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int one = mat[i][j] + solve(i - 1, j - 1, mat,dp);
    //     int two = mat[i][j] + solve(i - 1, j, mat,dp);
    //     int three = mat[i][j] + solve(i - 1, j + 1, mat,dp);

    //     return dp[i][j] = Math.min(one, Math.min(two, three));
    // }

    //     public int minFallingPathSum(int[][] matrix) {
    //         int[][] dp = new int[matrix.length][matrix.length];
    //         for(int[] put : dp) Arrays.fill(put , -1);
    //         int ans = Integer.MAX_VALUE;

    //         for (int j = 0; j < matrix[0].length; j++) {
    //             ans = Math.min(ans, solve(matrix.length - 1, j, matrix,dp));
    //         }

    //         return ans;
    //     }
    // }

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int one = Integer.MAX_VALUE;
                int two = Integer.MAX_VALUE;
                int three = Integer.MAX_VALUE;
                if (j > 0) {
                    one = matrix[i][j] + dp[i - 1][j - 1];
                }
                two = matrix[i][j] + dp[i - 1][j];

                if (j + 1 < matrix.length) {
                    three = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(one, Math.min(two, three));
            }
        }
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < matrix[0].length; j++) {
            ans = Math.min(ans, dp[matrix.length - 1][j]);
        }

        return ans;
    }
}