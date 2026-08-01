class Solution {
    public int[] nextGreaterElements(int[] nums) {

    int n = nums.length;
    Stack<Integer> st = new Stack<>();
     int[] arr = new int[n];


     for(int i=n-1;i>=0;i--){
        st.push(nums[i]);
     }

     for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && st.peek()<= nums[i]){
                st.pop();
            }
           arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
     }

     return arr;
    }
}