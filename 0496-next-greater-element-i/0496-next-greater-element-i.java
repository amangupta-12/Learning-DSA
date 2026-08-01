class Solution {
    public int[] nextGreaterElement(int[] nums2, int[] nums1) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums1.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<= nums1[i]){
                st.pop();
            }
            int val =  st.isEmpty() ? -1 : st.peek();
            map.put(nums1[i],val);
            st.push(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            nums2[i] = map.get(nums2[i]);
        }

        return nums2;
    }
}

       