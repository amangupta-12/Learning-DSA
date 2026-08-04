class Solution {
    private void solve(int[] nums,int idx,List<List<Integer>> result,ArrayList<Integer> curr){
        
            result.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i] == nums[i-1]) continue; 
        curr.add(nums[i]);
        solve(nums,i+1,result,curr);
        curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        solve(nums,0,result,curr);
        return result;
    }
}