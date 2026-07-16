class Solution {
    public int longestSubarray(int[] nums) {

        int n = nums.length;

        int i=0;
        int maxLen = 0;
        int countZeros = 0;
      for(int j=0;j<n;j++){
           if(nums[j]==0) countZeros++;

        while(countZeros>1){
            if(nums[i]==0) countZeros--;
            i++;
        }
        
        maxLen  = Math.max(maxLen , j-i);
      }
      
      return maxLen;
    }
}