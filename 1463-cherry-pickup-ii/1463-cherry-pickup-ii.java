class Solution {
    int solve(int i ,int j1 ,int j2,int[][] a,int[][][] dp){
        if(i >= a.length || j1 >= a[0].length || j1 < 0 || j2 >= a[0].length || j2 < 0) return -1000000009;

            if(i == a.length-1){
                if(j1 == j2) return a[i][j1];
                return a[i][j1] + a[i][j2];
            }

            if(dp[i][j1][j2] != -1 ) return dp[i][j1][j2];

            int maxi = Integer.MIN_VALUE;
                for(int dj1 = -1 ; dj1 <= 1 ; dj1++){
                    for(int dj2 = -1 ; dj2 <= 1 ;dj2++){
                        if(j1 == j2){
                         maxi = Math.max(maxi,a[i][j1] + solve(i+1,j1+dj1,j2+dj2,a,dp));
                        }else{
                          maxi = Math.max(maxi,a[i][j1] + a[i][j2] + solve(i+1,j1+dj1,j2+dj2,a,dp));
                        }

                    }
                }
            
        return dp[i][j1][j2] = maxi;  
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new  int[n][m][m];
        for(int[][] arr : dp){
            for(int[] put : arr){
                Arrays.fill(put , -1);
            }
        }

        return solve(0,0,m-1,grid,dp); 
    }
}