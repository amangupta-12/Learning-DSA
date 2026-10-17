class Solution {

    int getDigiSum(int val) {
        int sum = 0;
        while (val != 0) {
            sum += val % 10;
            val = val / 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        Integer[] copy = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(copy, (a, b) -> {
            int n1 = getDigiSum(a);
            int n2 = getDigiSum(b);

            if (n1 != n2) {
                return Integer.compare(n1, n2);
            }

            return Integer.compare(a, b);
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                int idx = map.get(copy[i]);
                nums[idx] = nums[i];
                nums[i] = copy[i];
                map.put(nums[i], i);
                map.put(nums[idx], idx);
                swap++;
            }
        }
        return swap;

    }
}