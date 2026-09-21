class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];

       for(int i=0;i<s.length();i++){
          dp[i][0] = 1;
       }

       for(int i=1;i<=s.length();i++){
        for(int j=1;j<=t.length();j++){
             int take = 0;
             if(s.charAt(i-1) == t.charAt(j-1)){
                take = dp[i-1][j-1];
             }
             int skip = dp[i-1][j];

             dp[i][j] = take + skip;
        }
       }

       return dp[s.length()][t.length()];
    }
}