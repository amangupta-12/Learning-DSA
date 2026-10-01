class Solution {

    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        // Empty string vs pattern
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

                boolean take = false;
                boolean skip = false;
                boolean extra = false;

                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {

                    take = dp[i - 1][j - 1];

                } else {

                    if (p.charAt(j - 1) == '*') {

                        extra = dp[i][j - 1] || dp[i - 1][j];

                    } else {

                        skip = false;
                    }
                }

                dp[i][j] = take || skip || extra;
            }
        }

        return dp[s.length()][p.length()];
    }
}