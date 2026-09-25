class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                pivot = i-1;
                break;
            }
        }
        if(pivot == -1){
           int m = 0;
           int o = nums.length-1;
            while(m < o){
            int temp = nums[m];
                nums[m] = nums[o];
                nums[o] = temp;
                m++; o--;
        }
        return;
        }
        for(int i=nums.length-1;i > pivot;i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        int m = pivot+1;
        int o = nums.length-1;
        while(m < o){
            int temp = nums[m];
                nums[m] = nums[o];
                nums[o] = temp;
                m++; o--;
        }

    }
}