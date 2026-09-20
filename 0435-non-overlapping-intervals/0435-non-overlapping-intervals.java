class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
    });
        int lastEnd = nums[0][1];
        int count = 1;
        for(int i=0;i<nums.length;i++){
            if(lastEnd <= nums[i][0]){
                count++;
                lastEnd = nums[i][1];
            }
        }
        return nums.length-count;

    }
}