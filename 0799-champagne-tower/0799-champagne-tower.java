class Solution {

    private double solve(int i ,int j , int poured,double[][] dp){
        if(i==0 && j==0) return poured;

        if(i<0 || j<0 || i<j) return 0.0;
        if(dp[i][j] != -1) return dp[i][j];

        double left = (solve(i-1,j,poured,dp)-1)/2.0;
        double right  = (solve(i-1,j-1,poured,dp)-1)/2.0;
        if(left < 0) left = 0.0;
        if(right < 0) right = 0.0;
        return dp[i][j] = left + right;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(query_row == 0 && query_glass == 0) return Math.min(1.0,poured);
        double[][] dp = new double[101][101];
       for(int i=0;i<101;i++){
        for(int j=0;j<101;j++){
            dp[i][j] = -1;
        }
       }
        return Math.min(1.0,solve( query_row, query_glass,poured,dp));
    }
}