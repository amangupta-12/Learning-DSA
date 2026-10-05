class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int[] prev = new int[nums.length+1];
        int[] curr = new int[nums.length+1];
            
            for(int i=nums.length-1 ; i>=0 ; i--){
                for(int j = i-1; j >= -1 ; j--){
                int take = 0;
                int skip = 0;
                if(j == -1 || nums[j] < nums[i]){
                    take = 1 + prev[i+1];
                }
                    skip = prev[j+1];
        
                      curr[j+1] = Math.max(take , skip);
                }
                prev = curr;
            }

            return curr[0];
    }
}
