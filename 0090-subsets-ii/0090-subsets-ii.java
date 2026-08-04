class Solution {
    private void solve(int[] nums,int idx,HashSet<List<Integer>> result,ArrayList<Integer> curr){
        if(idx >= nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(nums,idx+1,result,curr);
        curr.remove(curr.size()-1);
        solve(nums,idx+1,result,curr);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();

        solve(nums,0,result,curr);
        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;
    }
}