class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int sprev = 0;
        int prev = nums[0];
        int max = 0;
    
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(sprev + nums[i], prev);
            sprev = prev;
            prev = max;
        }

        return max;
    }
}