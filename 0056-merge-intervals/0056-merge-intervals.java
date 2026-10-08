class Solution {
    public int[][] merge(int[][] nums) {
     List<int[]> list = new ArrayList<>();

     Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));

     int s1 = nums[0][0];
     int e1 = nums[0][1];

     list.add(new int[]{s1,e1});
     for(int i=1;i<nums.length;i++){
        int s2 = nums[i][0];
        int e2 = nums[i][1];

        int start = 0;
        int end = 0;
        if(s1 <= e2 && s2 <= e1){
            list.remove(list.size()-1);
             start = Math.min(s1,s2);
             end = Math.max(e1,e2);
        }else{
            start = s2;
            end = e2;
        }
         list.add(new int[]{start,end});
        s1 = start;
        e1 = end;
     }

     int[][] ans = new int[list.size()][2];

for(int i = 0;i<list.size();i++){
    ans[i] = list.get(i);
}

return ans;
    }
}