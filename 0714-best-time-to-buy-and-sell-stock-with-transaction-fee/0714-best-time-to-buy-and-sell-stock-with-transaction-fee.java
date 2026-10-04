class Solution {
    int solve(int idx,int[] nums ,int decider,int[][] dp,int fee){
       if(idx == nums.length){
         return 0;
       }
       if(dp[idx][decider] != -1) return dp[idx][decider];

        long profit = 0;
        if(decider == 0){
            profit = Math.max(-nums[idx] + solve(idx+1,nums,1,dp,fee),
                    solve(idx+1,nums,0,dp,fee));
        }else{
            profit  = Math.max(-fee + nums[idx] + solve(idx+1,nums,0,dp,fee),
                        solve(idx+1,nums,1,dp,fee));
        }
        return dp[idx][decider] = (int) profit;
    }
     public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
           
           for(int[] put : dp) Arrays.fill(put , -1);
           return solve(0,prices,0,dp,fee);
    }
}