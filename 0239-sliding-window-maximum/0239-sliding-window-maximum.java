import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
       
       for(int i=0;i<nums.length;i++){
        while(!st.isEmpty() && st.peekFirst()<=i-k){
            st.removeFirst();
        }
        while(!st.isEmpty() && nums[st.peekLast()]< nums[i]){
            st.pollLast();
        }
        st.addLast(i);
        if(i >= k-1){
            res[i-k+1] = nums[st.peekFirst()];
        }
       }

       return res;
    }
}