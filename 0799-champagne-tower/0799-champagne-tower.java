class Solution {

    
    public double champagneTower(int poured, int r, int c) {
        if(r== 0 && c == 0) return Math.min(1.0,poured);
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

      for(int i=1;i<101;i++){
        for(int j=0;j<101;j++){
            double left =  (i<j)  ? 0.0 : Math.max(0.0,(dp[i-1][j]-1)/2.0);
            double right = (i<j || j-1<0) ? 0.0 : Math.max(0.0,(dp[i-1][j-1]-1)/2.0);

          
            dp[i][j] = left + right;
        }
      }

       return Math.min(1.0,dp[r][c]);
    }
}