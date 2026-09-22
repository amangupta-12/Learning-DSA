class Solution {
    private int lcs(String s , String t){
         int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                int take = 0;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    take  = 1 + dp[i-1][j-1];
                }
                int skip = Math.max(dp[i-1][j] , dp[i][j-1]);

                dp[i][j] = Math.max(take , skip);
            }
        }
        return dp[s.length()][t.length()];
    }
    
    public int minDistance(String s, String t) {
        int lc = lcs(s,t);
      return  (s.length() - lc) + (t.length() - lc);
}
}