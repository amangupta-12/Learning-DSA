class Solution {
     int solve(int i,int j,int[][] grid,int[][] dp){
            if(i == 0 && j == 0){
                return grid[i][j];
            }

            if(i < 0 || j < 0) return 1000000009;
            if(i >= 0 && j >= 0) if(dp[i][j] != -1) return dp[i][j];

            int up = grid[i][j] + solve(i-1,j,grid,dp);
            int left = grid[i][j] + solve(i,j-1,grid,dp);

            if( i < 0 || j < 0)  return 1000000009;
            return  dp[i][j] = Math.min(up,left);
            
        }
    public int minPathSum(int[][] grid) {

       int[][] dp = new int[grid.length][grid[0].length];
       for(int[] put : dp) Arrays.fill(put,-1);
        return solve(grid.length-1,grid[0].length-1,grid,dp);
    }
}