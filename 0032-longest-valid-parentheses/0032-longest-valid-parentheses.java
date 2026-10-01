class Solution {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        Stack<Integer>  st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                 if(!st.isEmpty()){
                int ele = st.peek();
                  arr[i] = 1;
                    arr[ele] = 1;
                        st.pop();
                }
            
            }
        }
        int count =0;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                count++;
            }else{
               max = Math.max(max,count);
                count = 0;
            }
        }
        max = Math.max(max,count);
        return max;
    }
}