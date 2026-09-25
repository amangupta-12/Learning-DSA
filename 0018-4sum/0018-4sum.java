class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-3){
            if(i > 0 && nums[i] == nums[i-1]){
                    i++;
                 continue;
            }
            int j=i+1;
            while(j<nums.length-2){
                if( j > i+1  && nums[j] == nums[j-1]){
                j++;
                continue;
            }
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else{
                    list.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k],nums[l])));
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
                j++;
            
            }
            i++;
        }
        return list;
    }
}