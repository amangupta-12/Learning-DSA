class Solution {
    public int maxValidPairSum(int[] nums, int k) {
     int n = nums.length;
     int[]  pre = new int[n];
     pre[0]  =  nums[0];
     for(int i=1;i<n;i++){
        pre[i] = Math.max(pre[i-1],nums[i]);
     }   
        int max =  -1;
     for(int i=k;i<n;i++){
        max =  Math.max(max,nums[i] + pre[i-k]);
     }
     return max ;
    }
}