class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));

        int count = 1;
        int end = points[0][1];

        for(int i=1;i<points.length;i++){
            int ns = points[i][0];
            int ne = points[i][1];

            if(ns > end){
                count++;
                end = ne;
            }
        }
        return count;
    }
}