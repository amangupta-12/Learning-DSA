import java.util.*;

class Solution {
   
   private void solve(int[] nums,int idx,List<List<Integer>> result,ArrayList<Integer> ans,int target){
            if(target == 0){
                result.add(new ArrayList<>(ans));
                return;
            }else if(idx == nums.length){
                return;
            }
                    if(target-nums[idx]>=0){
                        ans.add(nums[idx]);
                solve(nums,idx,result,ans,target-nums[idx]);
                    ans.remove(ans.size()-1);
                    target+=nums[idx];
                solve(nums,idx+1,result,ans,target-nums[idx]);
            }

   }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
       ArrayList<Integer> ans = new ArrayList<>();
            Arrays.sort(nums);
       solve(nums,0,result,ans,target);

       return result;
    }
}
