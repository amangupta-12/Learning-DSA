class Solution {

    private boolean solve(int idx,int[] nums,int sum,int total,Boolean[][] dp){
        
        if(idx == 0){
            return ((total - sum) == sum);
        }
        if(dp[idx][sum] != null) return dp[idx][sum];
        return dp[idx][sum] = (solve(idx-1,nums,sum+nums[idx],total,dp) || solve(idx-1,nums,sum,total,dp));
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        Boolean[][] dp = new Boolean[nums.length+1][20000];
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        return solve(nums.length-1,nums,0,total,dp);    
    }
}