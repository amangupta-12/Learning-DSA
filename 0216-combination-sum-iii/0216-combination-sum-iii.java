class Solution {
    int[] nums = {1,2,3,4,5,6,7,8,9};

    private void solve(int idx,int target,int k,int n,List<List<Integer>> result,ArrayList<Integer> curr){
        if(target == 0 && curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(idx == nums.length){
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(nums[i]>n) return;
            if(curr.size() != k && target-nums[i] >=0){
                curr.add(nums[i]);
                solve(i+1,target-nums[i],k,n,result,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> curr = new ArrayList<>();

    solve(0,n,k,n,result,curr);
        return result;
    }
}