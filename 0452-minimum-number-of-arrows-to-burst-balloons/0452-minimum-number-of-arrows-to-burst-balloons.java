class Solution {
    public int findMinArrowShots(int[][] nums) {

        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPosition = nums[0][1];

        for(int i = 1; i < nums.length; i++){
            if(arrowPosition < nums[i][0]){
                arrows++;
                arrowPosition = nums[i][1];
            }
        }

        return arrows;
    }
}