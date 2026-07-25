class Solution {

    private boolean dfs(int parity, int node, int[] colour,
            int[][] graph) {
        if (parity == 0) {
            colour[node] = 1;
            parity = 1;
        } else {
            colour[node] = 0;
            parity = 0;
        }
        for (int neighbour : graph[node]) {
            if (colour[neighbour] == -1) {
                if (dfs(parity, neighbour, colour, graph) == false) {
                    return false;
                }
            } else if (colour[neighbour] == colour[node]) {
                return false;
            }

        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] colour = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            colour[i] = -1;
        }
        int parity = 0;
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {
                if (dfs(parity, i, colour, graph) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
