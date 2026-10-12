class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1000000007L;
        int[] bit = new int[32];

        for(int j=0;j<nums.size();j++){
            for(int i=0;i<32;i++){
                if((nums.get(j) & (1 << i)) != 0){
                    bit[i]++;
                }
           }
        }
        long result = 0;
        while(k-- > 0){
            int curr = 0;
            for(int i=0;i<32;i++){
                if(bit[i] > 0){
                    curr = curr | (1 << i);
                    bit[i]--;
                }
            }
           result = (result + (long) curr * curr) % MOD;
        }
        return (int) result;
    }
}