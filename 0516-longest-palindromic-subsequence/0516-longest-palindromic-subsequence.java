class Solution {

    int lcs(int i,int j,String s,String t,int[][] dp){
       
       if( i < 0 || j < 0 ) return 0;

       if(dp[i][j] != -1) return dp[i][j];
            int take = 0,
                skip = 0;
             if(s.charAt(i) == t.charAt(j)){
         take = 1 + lcs(i-1,j-1,s,t,dp);
                }else{
        skip = Math.max(lcs(i-1,j,s,t,dp),lcs(i,j-1,s,t,dp));
              }

        return dp[i][j] = Math.max(take,skip);
    }
    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];
        
        for(int[] put : dp) Arrays.fill(put, -1);
        return lcs(s.length()-1,rev.length()-1,s,rev,dp);
    }
}


