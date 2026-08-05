class Solution {
    public int longestConsecutive(int[] nums) {
      HashSet<Integer> set = new HashSet<>();

      for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
      }  
        int maxCount = 0;
        int count = (nums.length == 0) ? 0 : 1;
      for(int i : set){
        if(!set.contains(i-1)){
            count = 1;
            int j = 1;
            while(true){
                if(set.contains(i+j)){
                    count++;
                    j++;
                }else{
                    maxCount = Math.max(count,maxCount);
                    break;
                }
            }
        }
      }
    return Math.max(count,maxCount);
    }
}