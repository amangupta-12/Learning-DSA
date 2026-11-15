class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        int i = 0;
        int j = 0; 
        int max = 0;
        while(j < nums.length){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            sum += nums[j];
            set.add(nums[j]);
            max = Math.max(sum , max);
            j++;
        }
        return max;
    }
}