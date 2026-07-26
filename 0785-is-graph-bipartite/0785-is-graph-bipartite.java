// class Solution {

//     private boolean dfs(int parity, int node, int[] colour,
//             int[][] graph) {
//         if (parity == 0) {
//             colour[node] = 1;
//             parity = 1;
//         } else {
//             colour[node] = 0;
//             parity = 0;
//         }
//         for (int neighbour : graph[node]) {
//             if (colour[neighbour] == -1) {
//                 if (dfs(parity, neighbour, colour, graph) == false) {
//                     return false;
//                 }
//             } else if (colour[neighbour] == colour[node]) {
//                 return false;
//             }

//         }
//         return true;
//     }

//     public boolean isBipartite(int[][] graph) {

//         int[] colour = new int[graph.length];
//         for (int i = 0; i < graph.length; i++) {
//             colour[i] = -1;
//         }
//         int parity = 0;
//         for (int i = 0; i < graph.length; i++) {
//             if (colour[i] == -1) {
//                 if (dfs(parity, i, colour, graph) == false) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }

// we solved the probem using bfs 
class Solution{
public boolean isBipartite(int[][] graph) {
    for(int start=0;start<graph.length;start++){ 
         // we used the for loop because the graph can be diaconneted so we used this
     int[] colour = new int[graph.length];
     Queue<Integer> q = new LinkedList<>();

        Arrays.fill(colour,-1);
        if(colour[start] != -1) continue;
        q.add(start);
        colour[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int neighbour : graph[node]){
                if(colour[neighbour] == -1){
                    colour[neighbour] = (colour[node]==1) ? 0 : 1; 
                    q.add(neighbour);
                }else if(colour[neighbour] == colour[node]){
                    return false;
                }
            }
        }
    }
        return true;
}
}