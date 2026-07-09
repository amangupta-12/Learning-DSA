class Solution {
    public int[] nextGreaterElements(int[] a) {
        int[] ans =  new int[a.length];
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int i = 2*n-1;
        while(i>=0){
        while(!st.isEmpty() && st.peek()<=a[i%n]){
            st.pop();
        }
        if(i<n){
           ans[i] = (st.isEmpty()) ? -1 : st.peek(); 
        }
        
        st.push(a[i%n]);
        i--;
        }
        return ans;
    }
}