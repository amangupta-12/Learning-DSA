class Solution {
    boolean solve(int idx , String s , HashSet<String> set,Boolean[] dp){
        if(idx  == s.length()){
            return true;
        }

        if(dp[idx] != null) return dp[idx]; 
        if(set.contains(s.substring(idx))) return true;

        for(int j = idx; j < s.length() ; j++){
            if(set.contains(s.substring(idx,j+1)) && solve(j+1,s,set,dp)){
                return  dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> list) {
        HashSet<String> set = new HashSet<>(list);
        Boolean[] dp = new Boolean[s.length()];
     return solve(0,s,set,dp);
    }
}