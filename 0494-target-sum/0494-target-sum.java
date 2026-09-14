class Solution {
   private int solve(int idx, int[] nums, int target) {
    if (idx == 0) {
    if (nums[0] == 0) {
        return target == 0 ? 2 : 0;
    }

    int ways = 0;

    if (target + nums[0] == 0) ways++;
    if (target - nums[0] == 0) ways++;

    return ways;
}

    int add = solve(idx - 1, nums, target + nums[idx]);
    int sub = solve(idx - 1, nums, target - nums[idx]);

    return add + sub;
}
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length-1,nums,target);
    }
}