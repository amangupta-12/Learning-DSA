class Solution {
    public int removeCoveredIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            if(Integer.compare(a[0],b[0]) != 0){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });

        int i = 0;
        int j = 1;
        int covered = 0;
        while(j < nums.length){

            int e1 = nums[i][1];
            int e2 = nums[j][1]; 

            if(e1 >= e2){
                covered++;
                j++;
            }else{
                i = j;
                j++;
            }
        }

        return nums.length - covered;
    }
}


       