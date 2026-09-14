class Solution {
    private int solve(int idx,int[] nums,int amount,int[][] dp){
        if(idx == 0){
            if(amount%nums[idx] == 0) return 1;
            return 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take = 0;
        if(amount-nums[idx] >=0){
        take = solve(idx,nums,amount-nums[idx],dp);
        }
        int skip = solve(idx-1,nums,amount,dp);
        return dp[idx][amount] =  take + skip;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] put : dp) Arrays.fill(put,-1);
        return solve(coins.length-1,coins,amount,dp);
    }
}