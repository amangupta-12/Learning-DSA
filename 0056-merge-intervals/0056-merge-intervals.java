class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return a[1] - b[1];
        });

        List<int[]> list = new ArrayList<>();
        int last = nums[0][1];
        int start = nums[0][0];
        list.add(new int[]{start ,last});
        for(int i=1;i<nums.length;i++){
            if(last >= nums[i][0]){
               last = Math.max(last,nums[i][1]);
                list.get(list.size()-1)[1] = last;
            }else{
                start = nums[i][0];
                last = nums[i][1];
                list.add(new int[] {start,last});
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
          ans[i] =  list.get(i);
        }
  return ans;
  }
}