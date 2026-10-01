class Solution {
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = i;
        for (int i = 0; i <= t.length(); i++)
            dp[0][i] = i;
        
            

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                int take = 1000000009;
                int skip = 1000000009;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    take = dp[i - 1][j - 1];
                } else {
                    skip = Math.min(1 + dp[i - 1][j],
                            Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j - 1]));
                }
                dp[i][j] = Math.min(take, skip);
            }
        }
        return dp[s.length()][t.length()];

    }
}

   