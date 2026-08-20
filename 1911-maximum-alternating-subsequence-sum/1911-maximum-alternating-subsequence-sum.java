class Solution {

    private long solve(int idx, int[] nums, boolean parity, long[][] dp) {

        if (idx >= nums.length) {
            return 0;
        }

        int p = parity ? 1 : 0;

        if (dp[idx][p] != -1) {
            return dp[idx][p];
        }

        long take;

        if (parity) {
            take = nums[idx] + solve(idx + 1, nums, false, dp);
        } else {
            take = -nums[idx] + solve(idx + 1, nums, true, dp);
        }

        long skip = solve(idx + 1, nums, parity, dp);

        return dp[idx][p] = Math.max(take, skip);
    }

    public long maxAlternatingSum(int[] nums) {

        long[][] dp = new long[nums.length][2];

        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(0, nums, true, dp);
    }
}