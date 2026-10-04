class Solution {
    int solve(int idx, int[] nums,  int[][] dp, int trans,int k) {
        if (idx == nums.length) {
            return 0;
        }
        if (trans == 2*k)
            return 0;
        if (dp[idx][trans] != -1)
            return dp[idx][trans];

        long profit = 0;
        if (trans % 2 == 0) {
            profit = Math.max(-nums[idx] + solve(idx + 1, nums, dp,trans+1,k),
                    solve(idx + 1, nums, dp, trans,k));
        } else {
            profit = Math.max(nums[idx] + solve(idx + 1, nums, dp, trans + 1,k),
                    solve(idx + 1, nums, dp, trans,k));
        }
        return dp[idx][trans] = (int) profit;
    }

     public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k];
        for (int[] arr : dp)
                Arrays.fill(arr, -1);
        return solve(0, prices,dp,0,k);
    }
}