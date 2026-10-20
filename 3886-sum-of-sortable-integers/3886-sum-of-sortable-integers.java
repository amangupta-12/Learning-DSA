import java.util.*;

class Solution {

    int[] buildLPS(int[] arr, int st, int k) {
        int[] lps = new int[k];
        int len = 0;

        for (int i = 1; i < k;) {
            if (arr[st + i] == arr[st + len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }

    boolean kmp(int[] nums, int[] sorted, int st, int k) {
        int[] lps = buildLPS(sorted, st, k);

        int i = 0;
        int j = 0;

        while (i < 2 * k - 1) {
            int val = nums[st + (i % k)];

            if (val == sorted[st + j]) {
                i++;
                j++;

                if (j == k) return true;

            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean possible = true;

            for (int st = 0; st < n; st += k) {
                if (!kmp(nums, sorted, st, k)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                sum += k;
            }
        }

        return sum;
    }
}