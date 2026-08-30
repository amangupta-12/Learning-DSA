// class Solution {

//     private int solve(int x, int y,int[][] nums,int[][] dp){
//         if(nums[nums.length-1][nums[0].length-1] != 1){
//           if(x == nums.length-1 && y == nums[0].length-1) return 1;
//         }

//             int path1 = 0, path2 = 0;
//         if(x >= 0 && x<nums.length && y>= 0 && y< nums[0].length){
//              if(nums[x][y] == 1) return 0;
//             if(dp[x][y] != -1) return dp[x][y];

//              path1  = solve(x+1,y,nums,dp);
//              path2  = solve(x,y+1,nums,dp);
//         }
//         return dp[x][y] = path1 + path2;
//     }
//     public int uniquePathsWithObstacles(int[][] nums) {
//         int[][] dp = new int[nums.length+1][nums[0].length+1];
//         for(int[] put : dp) Arrays.fill(put,-1);
//         return solve(0,0,nums,dp);
//     }
// }

        // Tabulation
 class Solution{
    public int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length; 
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(nums[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                    }
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }else{
                     int path1 = 0, path2 = 0;
                     if(i>0) path1 = dp[i-1][j];
                     if(j>0) path2 = dp[i][j-1];
        
                 dp[i][j] = path1 + path2;
                }
            }
        }
        return dp[m-1][n-1];
        }
 }