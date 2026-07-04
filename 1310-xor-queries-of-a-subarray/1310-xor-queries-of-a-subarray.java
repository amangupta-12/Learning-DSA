class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] ans = new int[queries.length];
        int[] pre = new int[n];
        pre[0] = arr[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]^arr[i];
        }

        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right  = queries[i][1];

            ans[i] = (left>0) ? pre[right]^pre[left-1] : pre[right];
        }
            return ans;
    }
}