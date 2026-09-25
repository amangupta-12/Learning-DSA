class Solution {
    boolean solve(int i,int j,int k,String s,String t,String f,Boolean[][] dp){
        if(i == s.length() && j == t.length()){
            return true;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        boolean take = false;
        boolean skip  = false;
        if(i < s.length() && s.charAt(i) == f.charAt(k)){
        take = solve(i+1,j,k+1,s,t,f,dp);
        }

         if(j < t.length() &&t.charAt(j) == f.charAt(k)){
        skip = solve(i,j+1,k+1,s,t,f,dp);
        }

       return dp[i][j] = take || skip;
    }
    public boolean isInterleave(String s, String t, String f) {
        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
     
        if((s.length() + t.length()) !=  f.length()) return false;
        return solve(0,0,0,s,t,f,dp);
    }
}