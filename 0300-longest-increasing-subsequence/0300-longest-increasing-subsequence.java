class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int left = 0;
            int right = list.size();
            while(left < right){
                int mid = left + (right-left)/2;
                if(list.get(mid) < nums[i]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }

            if(left == list.size()){
                list.add(nums[i]);
            }else{
                list.set(left,nums[i]);
            }
        }

        return list.size();
    }
}