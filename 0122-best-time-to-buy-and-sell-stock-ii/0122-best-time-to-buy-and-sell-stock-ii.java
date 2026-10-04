class Solution {
    int solve(int idx,int[] nums ,int decider,int[][] dp){
       if(idx == nums.length){
         return 0;
       }
       if(dp[idx][decider] != -1) return dp[idx][decider];

        long profit = 0;
        if(decider == 0){
            profit = Math.max(-nums[idx] + solve(idx+1,nums,1,dp),
                    solve(idx+1,nums,0,dp));
        }else{
            profit  = Math.max(nums[idx] + solve(idx+1,nums,0,dp),
                        solve(idx+1,nums,1,dp));
        }
        return dp[idx][decider] = (int) profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
            for(int[] put : dp) Arrays.fill(put,-1);
               return solve(0,prices,0,dp);
    }
}