class Solution {
    public int maxArea(int[] height) {

        long maxHeight = 0;
        int i = 0;
        int n = height.length;
        int j = n-1;

        while(i < j){
            int min  = Math.min(height[i],height[j]);
            maxHeight = Math.max(maxHeight , min*(j-i));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return (int)maxHeight;
    }
}
       