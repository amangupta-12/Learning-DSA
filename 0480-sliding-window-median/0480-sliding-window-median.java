
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> l = new TreeMap<>();
    TreeMap<Integer, Integer> r = new TreeMap<>();

    int leftSize = 0;
    int rightSize = 0;

    void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int x) {
        int val = map.get(x);

        if (val == 1) {
            map.remove(x);
        } else {
            map.put(x, val - 1);
        }
    }

    void insert(int x) {

        if (l.isEmpty() || x <= l.lastKey()) {
            add(l, x);
            leftSize++;
        } else {
            add(r, x);
            rightSize++;
        }

        balance();
    }

    void erase(int x) {

        if (l.containsKey(x)) {
            remove(l, x);
            leftSize--;
        } else {
            remove(r, x);
            rightSize--;
        }

        balance();
    }

    void balance() {

        while (leftSize > rightSize + 1) {
            int x = l.lastKey();

            remove(l, x);
            leftSize--;

            add(r, x);
            rightSize++;
        }

        while (leftSize < rightSize) {
            int x = r.firstKey();

            remove(r, x);
            rightSize--;

            add(l, x);
            leftSize++;
        }
    }

    double getMedian(int k) {

        if (k % 2 == 1) {
            return (double) l.lastKey();
        }

        return ((double) l.lastKey() + r.firstKey()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        l.clear();
        r.clear();
        leftSize = 0;
        rightSize = 0;

        for (int i = 0; i < k; i++) {
            insert(nums[i]);
        }

        ans[0] = getMedian(k);

        for (int i = k; i < n; i++) {

            // Remove outgoing element
            erase(nums[i - k]);

            // Insert incoming element
            insert(nums[i]);

            // Calculate median
            ans[i - k + 1] = getMedian(k);
        }

        return ans;
    }
}
