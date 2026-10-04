class Solution {
    int solve(int idx,int[] nums,int[][] dp,int buy){
        if(idx >= nums.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        long profit = 0;
        if(buy == 0){
        profit = Math.max(-nums[idx] + solve(idx+1,nums,dp,1),
                            solve(idx+1,nums,dp,0));
        }else{
            profit = Math.max(nums[idx] + solve(idx+2,nums,dp,0),
                            solve(idx+1,nums,dp,1));
        }
        return dp[idx][buy] = (int) profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] put : dp) Arrays.fill(put , -1);

        return solve(0,prices,dp,0);
    }
}