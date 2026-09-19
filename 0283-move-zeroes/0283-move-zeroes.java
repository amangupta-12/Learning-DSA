class Solution {
    public void moveZeroes(int[] nums) {
     int i=0,j=0;
     while(j<nums.length && i<nums.length){
        while(i< nums.length && nums[i] != 0){
            i++;
        }
         j = i+1;
        while(j<nums.length && nums[j] == 0){
            j++;
        }
         if(j<nums.length && i<nums.length && nums[i]==0 && nums[j]!=0){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
     }   
    }
}