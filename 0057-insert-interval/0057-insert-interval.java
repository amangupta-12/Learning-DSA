class Solution {
    public int[][] insert(int[][] nums, int[] ni) {
        ArrayList<int[]> list = new ArrayList<>();
        int i=0;
        while(i < nums.length && nums[i][1] < ni[0]){
            list.add(nums[i]);
            i++;
        }

        while(i <nums.length && (nums[i][0] <= ni[1] && ni[0] <= nums[i][1])){
            ni[0] = Math.min(nums[i][0],ni[0]);
            ni[1] = Math.max(nums[i][1],ni[1]);
            i++;
        }
        list.add(ni);

        while(i < nums.length){
            list.add(nums[i]);
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int k=0;k<list.size();k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}