class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 0;
        for (int k = 0; k < queries.length; k++) {
            int st = q[k][0] - x;
            int end = q[k][0];

            while (j < logs.length && logs[j][1] <= end) {
                map.put(logs[j][0], map.getOrDefault(logs[j][0], 0) + 1);
                j++;
            }
            
        while (i < j && logs[i][1] < st) {
            map.put(logs[i][0], map.get(logs[i][0]) - 1);
            if (map.get(logs[i][0]) == 0) {
                map.remove(logs[i][0]);
            }
            i++;
        }
        ans[q[k][1]] = n - map.size();
        }
        return ans;
    }
}