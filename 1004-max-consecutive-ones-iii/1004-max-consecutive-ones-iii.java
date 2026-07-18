class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int zero =0;
        int maxLen =0;
        int n = nums.length;
       int i=0;
       for(int j=0;j<n;j++){
            if(nums[j]==0){
                zero++;
            }
            while(zero>k){
                if(nums[i]==0){
                    zero--;
                }
                i++;
            }
            maxLen  = Math.max(maxLen,j-i+1);
       }

       return maxLen;
    }
}