class Solution {

    public boolean isInterleave(String s, String t, String f) {

        if(s.length() + t.length() != f.length()){
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];

        dp[0][0] = true;

        // Only s is used
        for(int i = 1; i <= s.length(); i++){
            if(s.charAt(i - 1) == f.charAt(i - 1)){
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Only t is used
        for(int j = 1; j <= t.length(); j++){
            if(t.charAt(j - 1) == f.charAt(j - 1)){
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){

                int k = i + j - 1;

                boolean take = false;
                boolean skip = false;

                if(s.charAt(i - 1) == f.charAt(k)){
                    take = dp[i - 1][j];
                }

                if(t.charAt(j - 1) == f.charAt(k)){
                    skip = dp[i][j - 1];
                }

                dp[i][j] = take || skip;
            }
        }

        return dp[s.length()][t.length()];
    }
}