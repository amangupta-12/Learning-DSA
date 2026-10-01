class Solution {

    int solve(int i ,int j ,String s ,String t,int[][] dp){
        if(i < 0 && j < 0){
            return 0;
        }
        if(i < 0) return j+1;
        if(j < 0) return i+1;

            if(dp[i][j] != -1) return dp[i][j];
            
        int take = 1000000009 ;
        int skip = 1000000009 ;
        if(s.charAt(i) == t.charAt(j)){
            take = solve(i-1,j-1,s,t,dp);
        }else{
            skip = Math.min( 1 + solve(i-1,j,s,t,dp),Math.min(1 + solve(i,j-1,s,t,dp),1 + solve(i-1,j-1,s,t,dp)));
        }
        return dp[i][j] = Math.min(take , skip); 
    }
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] put : dp) Arrays.fill(put,-1);
        return solve(s.length()-1,t.length()-1,s,t,dp);
    }
}

// delete -> i-1 , j
// insert -> i , j-1 
// replace -> i-1,j-1


