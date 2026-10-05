class Solution {
    int solve(int idx ,int[] nums,int prev,int[][] dp){
        if(idx >= nums.length) return 0; 

        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];

        int take = 0;
        int skip = 0;
        if(prev == -1 || nums[prev] < nums[idx]){
            take = 1 + solve(idx+1,nums,idx,dp);
        }
            skip = solve(idx+1,nums,prev,dp);
        
        return dp[idx][prev+1] = Math.max(take , skip);
    }
     public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] put : dp) Arrays.fill(put , -1);
        return solve(0,nums,-1,dp);
     }
}