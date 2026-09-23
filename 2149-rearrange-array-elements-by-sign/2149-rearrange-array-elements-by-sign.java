class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 0;
        int idx = 0;
        int[] ans = new int[nums.length];
       while(pos<nums.length && neg < nums.length){
            while(nums[pos]<0){
                pos++;
            }
            ans[idx] = nums[pos];
            idx++; pos++;
            while(nums[neg]>0){
                neg++;
            }
            ans[idx] = nums[neg];
            idx++ ; neg++;
        }
        return ans;
    }
        
    }
