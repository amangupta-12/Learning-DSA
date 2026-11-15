class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];
        even[0] = nums[0];
        odd[0] = 0;
       
        for(int i=1;i<nums.length;i++){
            if(i % 2 == 0){
                even[i] = even[i-1] + nums[i];
                odd[i] = odd[i-1];
            }else{
                odd[i] = odd[i-1] + nums[i];
                even[i] = even[i-1];
            }
        }
        
         
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int Even = 0;
        int Odd = 0;
            if(i > 0){
                Even += even[i-1];
                Odd += odd[i-1];
            }
                Odd += (even[nums.length-1]-even[i]);
                Even += (odd[nums.length-1]-odd[i]);
            if(Even == Odd) count++;
        }
        return count;
    }
}