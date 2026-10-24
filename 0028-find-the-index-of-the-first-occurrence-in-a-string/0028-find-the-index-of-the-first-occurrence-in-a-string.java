class Solution {

    int[] lps;
    void buildLps(String s){
        lps = new int[s.length()];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i <  s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else if(len > 0){
                len = lps[len-1];
            }else{
                lps[i] = 0;
                i++;
            }
        }
    }
    public int strStr(String haystack, String needle) {
        lps = new int[needle.length()];
        buildLps(needle);

        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            if(j == needle.length()) return i - j;
            }else if(j > 0){
                 j = lps[j-1];
            }else{
                i++;
            }
        }
        return -1;
    }
}