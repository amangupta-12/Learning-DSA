class Solution {
    public String removeKdigits(String s, int k) {

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
        while(!st.isEmpty() && ((st.peek()-'0')>(s.charAt(i)-'0')) && k!=0){
            st.pop();k--;                 
        }
            st.push(s.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
                st.pop();k--;
            }
        StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()){
                    sb.append(st.pop());
                } 
                sb.reverse();
                int len = 0;
               while(len<sb.length() && sb.charAt(len)=='0'){
               
                    len++;
               }
               if(len==sb.length()){
                return "0";
               }
                return sb.substring(len);
        }
}
      