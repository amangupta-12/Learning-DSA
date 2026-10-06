class Solution {
    
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       Arrays.fill(dp,1);

        int max = 1;
       for(int i=0;i<nums.length;i++){
        for(int prev = 0; prev < i ; prev++){
            if(nums[prev] < nums[i]){
            dp[i] = Math.max(1 + dp[prev] , dp[i]);
            max = Math.max(dp[i],max);
        }
        }
       }

       return max;
    }
}