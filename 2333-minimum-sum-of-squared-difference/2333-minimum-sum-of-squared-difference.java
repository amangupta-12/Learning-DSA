class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] f = new int[100001];
     int k = k1 + k2;

     for(int i =0;i<nums1.length;i++){
        int diff = Math.abs(nums1[i] - nums2[i]);
        f[diff]++;
     }
        int i = f.length-1;
        while(k > 0 && i >= 0){
        if(f[i] != 0){
            int countOps = Math.min(k,f[i]);
            f[i] -= countOps;
            if(i-1 >= 0) f[i-1] += countOps;
            k -= countOps;
        }
        i--;
    }
    long ans = 0;
    for(int j =0;j<f.length; j++){
       ans += (long) f[j] * j * j;
    }
        return ans;
    }
}