class Solution {
    private int solve(int idx, int[] arr, int amount,int[][] dp) {
        if (idx == 0) {
           if(amount%arr[idx] == 0) return amount / arr[idx];
           return (int) 1e9;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take = (int) 1e9;
        if (amount - arr[idx] >= 0) {
            take = 1 + solve(idx, arr,amount-arr[idx],dp);
        }
          int skip = solve(idx-1,arr,amount,dp);
        
         return dp[idx][amount] = Math.min(take,skip);          
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] put : dp) Arrays.fill(put,-1);
        int ans = solve(coins.length-1,coins,amount,dp);
        return (ans == (int) 1e9) ? -1 : ans ;
    }
}