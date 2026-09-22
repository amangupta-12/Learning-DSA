class Solution {
  
    public String shortestCommonSupersequence(String s, String t) {
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
        int idx = dp[s.length()][t.length()];

        String str ="";
        int m = s.length();
        int n = t.length();
        while(m>0 && n>0){
            if(s.charAt(m-1) == t.charAt(n-1)){
                str+=s.charAt(m-1);
                m--;
                n--;
            }else{
                if(dp[m][n-1] < dp[m-1][n]){
                    str+= s.charAt(m-1);
                    m--;
                }else{
                    str+= t.charAt(n-1);
                    n--;
                }
            }
        }
        while(m>0){
            str += s.charAt(m-1);
            m--;
        }
        while(n>0){
            str += t.charAt(n-1);
            n--;
        }
        String rev = new StringBuilder(str).reverse().toString();

        return rev;
    }
}