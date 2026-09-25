class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length){
            sum += nums[i];
            if(sum < 0){
                max = Math.max(max,sum);
                sum = 0;
            }else{
             max = Math.max(max,sum);
            }
             i++;
        }
       
        return max;
    }
}