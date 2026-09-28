import java.math.BigInteger;
class Solution {
    boolean notGood(ArrayList<Integer> list) {
    BigInteger found1 = BigInteger.ZERO;
    BigInteger found2 = BigInteger.ZERO;

    for (int x : list) {

        BigInteger bit = BigInteger.ONE.shiftLeft(x);

        if (!found2.and(bit).equals(BigInteger.ZERO)) {
            return true;
        }

        found2 = found2.or(found1.shiftLeft(x));

        found1 = found1.or(bit);
    }

    return false;
}
    public int maxSubarray(int[] nums) {
        int left = 0;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int right = 0; right < nums.length; right++) {
            int pos = Collections.binarySearch(list, nums[right]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            list.add(pos, nums[right]);

            while (notGood(list)) {
               int posi = Collections.binarySearch(list,nums[left]);
               list.remove(posi);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}