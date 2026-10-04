class Solution {
    int solve(int idx, int[] nums, int decider, int[][][] dp, int trans) {
        if (idx == nums.length) {
            return 0;
        }
        if (trans == 2)
            return 0;
        if (dp[idx][decider][trans] != -1)
            return dp[idx][decider][trans];

        long profit = 0;
        if (decider == 0) {
            profit = Math.max(-nums[idx] + solve(idx + 1, nums, 1, dp, trans),
                    solve(idx + 1, nums, 0, dp, trans));
        } else {
            profit = Math.max(nums[idx] + solve(idx + 1, nums, 0, dp, trans + 1),
                    solve(idx + 1, nums, 1, dp, trans));
        }
        return dp[idx][decider][trans] = (int) profit;
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] arr : dp)
            for (int[] row : arr)
                Arrays.fill(row, -1);
        return solve(0, prices, 0, dp, 0);
    }
}