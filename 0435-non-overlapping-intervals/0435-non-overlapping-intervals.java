class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        
        Arrays.sort(nums,(a,b)->{
            if(Integer.compare(a[0],b[0]) != 0){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[0],a[0]);
        });
        int overlap = 0;
        int i = 0;
        int j = 1;
        while( j < nums.length){
            int s1 = nums[i][0];
            int e1 = nums[i][1];
            int s2 = nums[j][0];
            int e2 = nums[j][1];

            if(e1 > s2 ){
                overlap++;
               if(e1 > e2){
                i = j;
                j++;
               }else{
                j++;
               }
            }else{
                i = j;
                j++;
            }
        }
       
       return overlap;
    }
}