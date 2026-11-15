class Solution {
    public int maxNonOverlapping(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
       
        int sum = 0;
        set.add(0);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(set.contains(sum - k)){
                count++;
                set.clear();
                set.add(0);
                sum = 0;
            }else{
             set.add(sum);
            }
        }
       
        
        return count;
    }
}