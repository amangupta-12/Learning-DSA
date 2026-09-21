class Solution {

    int solve(int i,int j,String s ,String t,int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
            int take = 0;
            if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
        take = solve(i-1,j-1,s,t,dp);
        }
        int skip = solve(i-1,j,s,t,dp);
        return dp[i][j] = take + skip;
    }
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int[][] dp = new int[s.length()][t.length()];
        for(int[] put : dp) Arrays.fill(put,-1);
        return solve(s.length()-1,t.length()-1,s,t,dp);
    }
}