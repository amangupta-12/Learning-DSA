// class Solution {

//     private boolean solve(int idx,int[] nums,int sum,int total,Boolean[][] dp){
        
//         if(idx == 0){
//             return ((total - sum) == sum);
//         }
//         if(dp[idx][sum] != null) return dp[idx][sum];
//         return dp[idx][sum] = (solve(idx-1,nums,sum+nums[idx],total,dp) || solve(idx-1,nums,sum,total,dp));
//     }

//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         Boolean[][] dp = new Boolean[nums.length+1][20000];
//         for(int i=0;i<nums.length;i++){
//             total += nums[i];
//         }
//         return solve(nums.length-1,nums,0,total,dp);    
//     }
// }

// Tabulation 
class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        if(total % 2 == 1) return false;

        int target = total / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= target; j++) {

                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] ||
                               dp[i-1][j - nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}