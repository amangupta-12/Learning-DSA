class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int pro = 1;
        int start=0;
        int ans = 0;
       for(int i=0;i<nums.length;i++){
        pro*=nums[i];
            while(pro>=k){
                pro/=nums[start];
                start++;
            }
            ans+=i-start+1;

        }
        return ans;
    }
}