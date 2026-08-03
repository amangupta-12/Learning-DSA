class Solution {

    private void solve(int[] nums,List<List<Integer>> result,ArrayList<Integer> curr,HashSet<Integer> used){
            if(curr.size() == nums.length){
                result.add(new ArrayList<>(curr));
                return;
            }

            for(int i=0;i<nums.length;i++){
                if(!used.contains(nums[i])){
                    curr.add(nums[i]);
                    used.add(nums[i]);
                    solve(nums,result,curr,used);
                    used.remove(nums[i]);
                    curr.remove(curr.size()-1);
                }
            }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();

        solve(nums,result,curr,used);

        return result;
    }
}