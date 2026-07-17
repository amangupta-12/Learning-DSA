import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();


        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        list.add(nums[dq.peekFirst()]);

        int i = 1;


        for (int j = k; j < n; j++) {


            if (!dq.isEmpty() && dq.peekFirst() == i - 1) {
                dq.pollFirst();
            }

            
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) {
                dq.pollLast();
            }

            dq.addLast(j);

            list.add(nums[dq.peekFirst()]);

            i++;
        }

        int[] ans = new int[list.size()];

        for (int x = 0; x < list.size(); x++) {
            ans[x] = list.get(x);
        }

        return ans;
    }
}