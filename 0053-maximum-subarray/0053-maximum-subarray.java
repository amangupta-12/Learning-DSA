class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        boolean pos = false;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum < 0){
                sum = 0;
            }else{
                pos = true;
            }
          
           max = Math.max(sum,max);
        }
        
        if(!pos){
            max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                max = Math.max(max,nums[i]);
            }
        }
        return max;
    }
}