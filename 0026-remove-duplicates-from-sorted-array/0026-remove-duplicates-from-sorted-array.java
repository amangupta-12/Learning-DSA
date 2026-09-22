class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int i=0; int j =0;
        while(i<nums.length && j < nums.length){
            j = i+1;
            while( j<nums.length && nums[j] <= nums[i]){
                j++;
            }
            if(i+1 < nums.length && j < nums.length){
            nums[i+1] = nums[j];
            }
            len = i;
            i++;
        }
        return len+1;
    }
}