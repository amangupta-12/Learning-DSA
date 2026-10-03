class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)-> Integer.compare(a[0],b[0]));

        int i = 0;
        int j = 1;
        int count = 0;
        while(j < nums.length){
            int cs = nums[i][0];
            int ce = nums[i][1];
            int ns = nums[j][0];
            int ne = nums[j][1];

            if(ns < ce){
                count++;

                if(ce <= ne){
                    j++;
                }else{
                    i = j;
                    j++;
                }
            }else{
                i = j;
                j++;
            }
        }

        return count;
    }
}

