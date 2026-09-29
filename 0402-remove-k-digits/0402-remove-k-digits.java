class Solution {
    public String removeKdigits(String num, int k) {
        if( num.length() == k) return "0";
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<num.length();i++){
            while(k != 0 && ans.length() > 0 &&  (ans.charAt(ans.length()-1) > num.charAt(i))){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            ans.append(num.charAt(i));
        }
        while(k > 0){
            ans.deleteCharAt(ans.length()-1);
            k--;
        }
        int it = 0;
        boolean nonZero = false;
       while(it < ans.length()){
        if(ans.charAt(it) != '0'){
            nonZero = true;
            break;
        }
        it++;
       }
       if(!nonZero) return "0";
        int m = 0;
        while(m < ans.length() && ans.charAt(m) == '0'){
            ans.deleteCharAt(m);
        }
        return ans.toString();
    }
}