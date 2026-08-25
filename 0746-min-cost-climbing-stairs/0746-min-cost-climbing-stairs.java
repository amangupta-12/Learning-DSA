class Solution {

    private int solve(int idx , int[] cost,int[] dp){
        if(idx >= cost.length) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int take = cost[idx] + solve(idx+1 , cost,dp);
        int skip = cost[idx] + solve(idx+2 , cost,dp);

        return dp[idx] =  Math.min(take,skip);
    } 
    public int minCostClimbingStairs(int[] cost) {
        int[] dp =  new int[cost.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp,-1);
        }
      
      return Math.min(solve(0,cost,dp),solve(1,cost,dp));
    }
} 