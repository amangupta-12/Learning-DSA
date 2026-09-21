class Solution {
  
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        int target = (total/2);
        if(total%2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][target+1];

            for(int i=0;i<nums.length;i++){
                dp[i][0] = true;
            }
            if(nums[0]<=target) dp[0][nums[0]] = true;

            for(int i=1;i<nums.length;i++){
                for(int j=0;j<=target;j++){
                    boolean take = false;
                    if(nums[i]<=j){
                        take = dp[i-1][j-nums[i]];
                    }
                    boolean skip = dp[i-1][j];

                    dp[i][j] = take || skip;
                }
            }
            return dp[nums.length-1][target];
    }
}
            