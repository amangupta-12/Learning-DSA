class Solution {
    public int minimumCost(int[] nums, int k) {

        long MOD = 1000000007L;

        long ops = 0;
        long dum = k;

        for (int i = 0; i < nums.length; i++) {

            if (dum < nums[i]) {

                long rem = nums[i] - dum;

                long val = (rem + k - 1L) / k;

                ops += val;

                dum = dum + val * (long) k - nums[i];
            } else {
                dum -= nums[i];
            }
        }
// we are using this to prevent overflow 
        // we are doing (n*(n+1))/2
        long a = ops;
        long b = ops + 1;

        if ((a & 1) == 0) {
            a /= 2;
        } else {
            b /= 2;
        }

        long cost = ((a % MOD) * (b % MOD)) % MOD;

        return (int) cost;
    }
}