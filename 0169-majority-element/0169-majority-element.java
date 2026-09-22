class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int var = 0;

        for(int i = 0; i < nums.length; i++) {

            if(count == 0) {
                var = nums[i];
            }

            if(var == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return var;
    }
}