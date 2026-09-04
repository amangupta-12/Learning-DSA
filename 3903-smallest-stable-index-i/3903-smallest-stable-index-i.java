class Solution {
    public int firstStableIndex(int[] nums, int k) {

        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

            int[] suff = new int[n];
        for (int i =n-1; i>=0; i--) {
           if(nums[i]<min){
               suff[i] = nums[i];
               min = nums[i];
           }else{
               suff[i] = min;
           }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (max - suff[i] <= k) {
                return i;
            }
           
            }


        return -1;
    }
}