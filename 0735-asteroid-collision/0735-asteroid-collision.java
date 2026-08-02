class Solution {
    public int[] asteroidCollision(int[] arr) {

        Stack<Integer> st = new Stack<>();
    for(int i=0;i<arr.length;i++){
        while(!st.isEmpty() && st.peek()>0 && arr[i]<0 && st.peek()< Math.abs(arr[i])){
            st.pop();
        }
        if(!st.isEmpty() && st.peek()>0 && arr[i]<0 && st.peek()==Math.abs(arr[i])){
            st.pop();
            continue;
        }
        if(!st.isEmpty() && st.peek()>0 && arr[i]<0 && st.peek()>Math.abs(arr[i])){
            continue;
        }
        st.push(arr[i]);
    }
    
    int n = st.size();
    int[] ans = new int[n];
for(int i = n - 1; i >= 0; i--){
    ans[i] = st.pop();
}
      
return ans;
    }
}