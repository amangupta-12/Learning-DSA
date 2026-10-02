class Solution {
    public int removeCoveredIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b) ->{
            if(a[0] != b[0]){
                return  Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(b[1],a[1]);
            }
        });

        int count = 0;
        int s1 = nums[0][0];
        int e1 = nums[0][1];
        int maxEnd = e1;
        for(int i=1;i<nums.length;i++){
            int s2 = nums[i][0];
            int e2 = nums[i][1];
          
            if(s2 <= maxEnd && e2 <= maxEnd){
                count++;
            }else{
               maxEnd = e2;
            }

        }
        return nums.length - count;
    }
}