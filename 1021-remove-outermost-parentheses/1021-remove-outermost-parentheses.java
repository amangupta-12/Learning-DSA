class Solution {
    public String removeOuterParentheses(String s) {
        int value = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                value++;
                if(value == 1) continue;
            }else{
                value--;
            }
            if(value > 0){
                sb.append(s.charAt(i));
            }
        }
        

        return sb.toString();
    }
}