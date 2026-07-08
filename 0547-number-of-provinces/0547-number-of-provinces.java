class Solution {
    void dfs(int node,boolean[] vis,int[][] isConnected){
        vis[node] = true;
        for(int nbr=0;nbr<isConnected.length;nbr++){
            if(isConnected[node][nbr]==1 && (!vis[nbr])){
                dfs(nbr,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            vis[i] = false;
        }

        int province = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                province++;
                dfs(i,vis,isConnected);
            }
        }
        return province;
    }
}