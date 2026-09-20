class Solution {
    public int[][] insert(int[][] nums, int[] ne) {

        List<int[]> list = new ArrayList<>();

        int i = 0;

        
        while (i < nums.length && nums[i][1] < ne[0]) {
            list.add(nums[i]);
            i++;
        }


        while (i < nums.length && nums[i][0] <= ne[1]) {
            ne[0] = Math.min(ne[0], nums[i][0]);
            ne[1] = Math.max(ne[1], nums[i][1]);
            i++;
        }

        list.add(ne);

        
        while (i < nums.length) {
            list.add(nums[i]);
            i++;
        }

        int[][] ans = new int[list.size()][2];

        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }

        return ans;
    }
}