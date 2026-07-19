class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int sum = 0;
      int n = nums.length;
      int i=0,j=0;
        int ans = Integer.MAX_VALUE;
        boolean visit = false;
      while(j<n && i<n){
        sum+=nums[j];

        while(sum >= target){
            ans = Math.min(ans,j-i+1);
            sum-=nums[i];
            i++;
            visit = true;
        }
        j++;
      }

      return (visit) ? ans : 0;
    }
}

