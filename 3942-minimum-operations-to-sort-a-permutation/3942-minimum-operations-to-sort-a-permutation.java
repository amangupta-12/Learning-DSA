class Solution {
    
    int neg = 1_000_000_000;
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

    int kmp(int[] nums, int[] sorted, int st, int k) {
        int[] lps = buildLPS(sorted, st, k);

        int i = 0;
        int j = 0;

        while (i < 2 * k - 1) {
            int val = nums[st + (i % k)];

            if (val == sorted[st + j]) {
                i++;
                j++;

                if (j == k) return i-k;

            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return neg;
    }
    static void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] sidha = nums.clone();
        int[] ulta = nums.clone();
       reverse(ulta);

        int[] sort = nums.clone();
        Arrays.sort(sort);
        int[] revSort = sort.clone();
        reverse(revSort);
       
            int one = Math.min(kmp(sidha , sort , 0 , n) , 1+ kmp(sidha , revSort , 0 , n));
            int two = Math.min( 1 + kmp(ulta , sort , 0 , n) , 2 + kmp(ulta , revSort , 0 , n));
            int answer = Math.min(one, two);
        return (answer >= neg) ? -1 : answer;
    }
}